-- task2 - 1 display fails in schedule(cross films)
with filmsRanges as (
select s.id id, s.start, s.start + (f.length * interval '1 minute') as endShow, f.length , f.name
from cinema.shows s
    left join cinema.films f on f.id = s.film_id)
select f1.name film1, s1.start start1, f1.length length1,
       fr.name film2, fr.start start2, fr.length length2
       from cinema.shows s1 left join cinema.films f1 on s1.film_id = f1.id join filmsRanges fr on s1.start > fr.start where s1.start < fr.endShow;

-- task2 - 2 display brakes more then 30 minutes
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

-- task2 - 3 - display profit report
with filmReport as (
    select f.name, count(t1.show_id) tickets, count(t1.show_id) ticketsTotal, count(t1.show_id) * s.price profit
    from cinema.shows s
             left join cinema.films f on f.id = s.film_id
             left join cinema.tickets t1 on s.id = t1.show_id
    group by f.id, s.price),
     showsCount as (
         select f1.name, count(s2.id) showsTotal
         from cinema.shows s2
                  left join cinema.films f1 on f1.id = s2.film_id
         group by f1.name
     ),
     result as (
         select fr.name,
                sum(fr.tickets)                   tickets,
                sum(sc.showsTotal)                shows,
                sum(fr.profit)                    profit,
                sum(tickets) / sum(sc.showsTotal) average_visitors
         from filmReport fr
                  left join showsCount sc on fr.name = sc.name
         group by fr.name order by profit desc)
select *
from result union all
        (select 'Total',
                sum(tickets),
                sum(shows),
                sum(profit),
                sum(tickets) / sum(shows)
         from result);


