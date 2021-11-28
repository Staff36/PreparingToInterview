with filmsRanges as (
    select s.id id, s.start, s.start + (f.length * interval '1 minute') as endShow, f.length , f.name
    from cinema.shows s
             left join cinema.films f on f.id = s.film_id)
select f1.name film1, s1.start start1, f1.length length1,
       fr.name film2, fr.start start2, fr.length length2
from cinema.shows s1 left join cinema.films f1 on s1.film_id = f1.id join filmsRanges fr on s1.start > fr.start where s1.start < fr.endShow;