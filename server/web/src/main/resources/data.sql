--
#
insert ignore into body_types(id, body_type)
values (1, 'купе');
insert ignore into body_types(id, body_type)
values (2, 'универсал');
insert ignore into body_types(id, body_type)
values (3, 'седан');
insert ignore into body_types(id, body_type)
values (4, 'кабриолет');
insert ignore into body_types(id, body_type)
values (5, 'родстер');

--
#bmw generations 2003 year

insert ignore into generations(id, generation, start_year, finish_year)
values (1, 'E46', 1998, 2006);
--
#body types
insert ignore into body_type_generations(body_type_id, generation_id)
VALUES (1, 1);
insert ignore into body_type_generations(body_type_id, generation_id)
VALUES (2, 1);
insert ignore into body_type_generations(body_type_id, generation_id)
VALUES (3, 1);
insert ignore into body_type_generations(body_type_id, generation_id)
VALUES (4, 1);
--
#bmw releaseYear
insert ignore into release_years(id, release_year)
values (1, 1998);
insert ignore into release_years(id, release_year)
values (2, 1999);
insert ignore into release_years(id, release_year)
values (3, 2000);
insert ignore into release_years(id, release_year)
values (4, 2001);
insert ignore into release_years(id, release_year)
values (5, 2002);
insert ignore into release_years(id, release_year)
values (6, 2003);
insert ignore into release_years(id, release_year)
values (7, 2004);
insert ignore into release_years(id, release_year)
values (8, 2005);
insert ignore into release_years(id, release_year)
values (9, 2006);
--
insert ignore into release_year_generation(release_year_id, generation_id)
VALUES (1, 1);
insert ignore into release_year_generation(release_year_id, generation_id)
VALUES (2, 1);
insert ignore into release_year_generation(release_year_id, generation_id)
VALUES (3, 1);
insert ignore into release_year_generation(release_year_id, generation_id)
VALUES (4, 1);
insert ignore into release_year_generation(release_year_id, generation_id)
VALUES (5, 1);
insert ignore into release_year_generation(release_year_id, generation_id)
VALUES (6, 1);
insert ignore into release_year_generation(release_year_id, generation_id)
VALUES (7, 1);
insert ignore into release_year_generation(release_year_id, generation_id)
VALUES (8, 1);
insert ignore into release_year_generation(release_year_id, generation_id)
VALUES (9, 1);
--
insert ignore into models(id, name)
VALUES (1, '3 серия');
--
insert ignore into model_release_years(release_year_id, model_id)
VALUES (1, 1);
insert ignore into model_release_years(release_year_id, model_id)
VALUES (2, 1);
insert ignore into model_release_years(release_year_id, model_id)
VALUES (3, 1);
insert ignore into model_release_years(release_year_id, model_id)
VALUES (4, 1);
insert ignore into model_release_years(release_year_id, model_id)
VALUES (5, 1);
insert ignore into model_release_years(release_year_id, model_id)
VALUES (6, 1);
insert ignore into model_release_years(release_year_id, model_id)
VALUES (7, 1);
insert ignore into model_release_years(release_year_id, model_id)
VALUES (8, 1);
insert ignore into model_release_years(release_year_id, model_id)
VALUES (9, 1);
--
insert ignore into brands(id, title)
values (1, 'BMW');
--
insert ignore into brand_models(model_id, brand_id)
VALUES (1, 1);
--


###safety###
insert ignore into safeties(id, safety)
VALUES (1, 'ABS (антиблокировочная система)');
insert ignore into safeties(id, safety)
VALUES (2, 'ESP (система поддержания динамической стабильности)');
insert ignore into safeties(id, safety)
VALUES (3, 'Антипробуксовочная система');
insert ignore into safeties(id, safety)
VALUES (4, 'Иммобилайзер');
insert ignore into safeties(id, safety)
VALUES (5, 'Подушки безопасности боковые');
insert ignore into safeties(id, safety)
VALUES (6, 'Подушки безопасности задние');
insert ignore into safeties(id, safety)
VALUES (7, 'Подушки безопасности передние');
insert ignore into safeties(id, safety)
VALUES (8, 'Сигнализация');
#########################


### COLOR ###
insert ignore into colors(id, color)
VALUES (1, 'белый');
insert ignore into colors(id, color)
VALUES (2, 'бордовый');
insert ignore into colors(id, color)
VALUES (3, 'жёлтый');
insert ignore into colors(id, color)
VALUES (4, 'зеленый');
insert ignore into colors(id, color)
VALUES (5, 'коричневый');
insert ignore into colors(id, color)
VALUES (6, 'красный');
insert ignore into colors(id, color)
VALUES (7, 'оранжевый');
insert ignore into colors(id, color)
VALUES (8, 'серебристый');
insert ignore into colors(id, color)
VALUES (9, 'серый');
insert ignore into colors(id, color)
VALUES (10, 'синий');
insert ignore into colors(id, color)
VALUES (11, 'фиолетовый');
insert ignore into colors(id, color)
VALUES (12, 'черный');
insert ignore into colors(id, color)
VALUES (13, 'другой');
###########################################

### INTERIOR ###

### interior ###
insert ignore into interior(id, interior)
values (1, 'Люк');
insert ignore into interior(id, interior)
values (2, 'Панорамная крыша');
#########################

### interior color ###
insert ignore into interior_colors(id, interior_color)
values (1, 'Светлый');
insert ignore into interior_colors(id, interior_color)
values (2, 'Темный');
insert ignore into interior_colors(id, interior_color)
values (3, 'Комбинированный');
#########################


### interior material ###
insert ignore into interior_materials(id, interior_material)
values (1, 'Натуральная кожа');
insert ignore into interior_materials(id, interior_material)
values (2, 'Искусственная кожа');
insert ignore into interior_materials(id, interior_material)
values (4, 'Ткань');
insert ignore into interior_materials(id, interior_material)
values (5, 'Велюр');
insert ignore into interior_materials(id, interior_material)
values (6, 'Алькантара');
insert ignore into interior_materials(id, interior_material)
values (7, 'Комбинированный');
#########################


#########################№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№
##  ##

##############
insert ignore into whell_drive_types(id, wheel_drive_type)
values (1, 'Передний');
insert ignore into whell_drive_types(id, wheel_drive_type)
values (2, 'Задний');
insert ignore into whell_drive_types(id, wheel_drive_type)
values (3, 'Подключаемый полный');
insert ignore into whell_drive_types(id, wheel_drive_type)
values (4, 'Постоянный полный');
##############


##############
insert ignore into transmission_types(id, transmission_type)
VALUES (1, 'Механика');
insert ignore into transmission_types(id, transmission_type)
VALUES (2, 'Автомат');
##############


##############
insert ignore into engine_types(id, engine_type)
values (1, 'бензин');
insert ignore into engine_types(id, engine_type)
values (2, 'бензин (гибрид)');
insert ignore into engine_types(id, engine_type)
values (3, 'бензин (метан)');
insert ignore into engine_types(id, engine_type)
values (4, 'бензин (пропан-бутан)');
insert ignore into engine_types(id, engine_type)
values (5, 'дизель');
insert ignore into engine_types(id, engine_type)
values (6, 'дизель (гибрид)');
insert ignore into engine_types(id, engine_type)
values (7, 'электро');
##############


##############
insert ignore into conditions(id, value)
VALUES (1, 'С пробегом');
insert ignore into conditions(id, value)
VALUES (2, 'С повреждениями');
insert ignore into conditions(id, value)
VALUES (3, 'На запчасти');
insert ignore into conditions(id, value)
VALUES (4, 'Новый');
##############

#########################№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№№
