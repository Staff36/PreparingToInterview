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


