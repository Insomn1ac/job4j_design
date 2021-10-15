select c.car_name as "Модель", b.body as "Тип кузова", e.engine as "Объем двигателя", t.transmission as "Коробка передач"
from car as c
join body as b on c.body_id = b.id
join engine as e on c.engine_id = e.id
join transmission as t on c.transmission_id = t.id
order by e.engine, c.car_name;

select b.body as "Тип кузова" from body as b
left join car as c on c.body_id = b.id
where c.car_name is null;

select e.engine as "Объем двигателя" from car as c
right join engine as e on c.engine_id = e.id
where c.car_name is null;