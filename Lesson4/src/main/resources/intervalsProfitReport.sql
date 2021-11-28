select case when (extract(hour from s.start) >= 9 and extract(hour from s.start) < 15) then 'from 9 to 15'
            when (extract(hour from s.start) >= 15 and extract(hour from s.start) < 18) then 'from 15 to 18'
            when (extract(hour from s.start) >= 18 and extract(hour from s.start) < 21) then 'from 18 to 21'
            when (extract(hour from s.start) >= 21 and extract(hour from s.start) <= 23) then 'from 18 to 21'
            else 'others'
            end period,
       count(t.id) visitors,
       sum(s.price) profit
from cinema.shows s join cinema.tickets t on t.show_id = s.id group by period;
