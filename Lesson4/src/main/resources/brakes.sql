with sortedShows as (
    select s.start, s.start + (f.length * interval '1 minute') as endShow, f.length , f.name
    from cinema.shows s
             left join cinema.films f on f.id = s.film_id
    order by s.start
), numberedShows as (
    select row_number() over () number, ss.start, ss.endShow, ss.length, ss.name
    from sortedShows ss
), ranges as (
    select ns1.name show1, ns1.start, ns1.length, ns2.name show2,(ns2.start - ns1.start) period
    from numberedShows ns1
             left join numberedShows ns2 on ns2.number = ns1.number + 1
)
select  show1, start, length ,show2,extract(mins from period) breaktime from ranges where extract(mins from period) >= 30 order by breaktime desc;