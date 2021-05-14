/*
INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, category, penalty, points)
	VALUES (1, 'Mileve Maric 5', 'Novi Sad', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Jovana', 'Jovanic', '0628876678', 'Jovanic', 0, 0, 0);
   
INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, category, penalty, points)
	VALUES (2, 'Glavna 100', 'Ruma', 'Srbija', '', 'sara@gmail.com', false, false, 'Sara', 'Saric', '0648816428', 'Saric', 0, 0, 0);
INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, category, penalty, points)
	VALUES (3, 'Lenjinova 20', 'Ruma', 'Srbija', '', 'aleksandramilijevic98@gmail', false, false, 'Luka', 'Lukic', '0612334555', 'Lukic', 0, 0, 0);
*/
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, points)
	VALUES (88, 'Mileve Maric 5', 'Novi Sad', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Jovana', 'Jovanic', '0628876678', 'Jovanic','jocas', 0, 27);
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, points)
	VALUES (89, 'Glavna 100', 'Ruma', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Sara', 'Saric', '0648816428', 'Saric','sara', 0, 0);
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, points)
	VALUES (90, 'Lenjinova 20', 'Ruma', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Luka', 'Lukic', '0612334555', 'Lukic','luka',0, 0);
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, points)
	VALUES (69, 'Синђелићева 44', 'Нови Сад', 'Србија', '', 'ta.drcelic@gmail.com', false, false, 'Aлекса', 'sifra', '0612334555', 'Реповић','aleksarep',0, 0);

INSERT INTO public.pharmacy(id, address, name, counseling_price) VALUES (111, 'Stanoja Stanojevica 4,Novi Sad,Srbija', 'Feniks', 1000.0);
INSERT INTO public.pharmacy(id, address, name, counseling_price) VALUES (222, 'Maksima Gorkog 44,Novi Sad,Srbija', 'Benu', 2000.0);
INSERT INTO public.pharmacy(id, address, counseling_price, name)VALUES (333, 'Boracka,Pljevlja,Crna Gora', 500.00, 'Sunce');
INSERT INTO public.pharmacy(id, address, counseling_price, name)VALUES (444, 'Sekspirova 10,Novi Sad,Srbija', 1200.00, 'Heba');   
INSERT INTO public.pharmacy(id, address, counseling_price, name)VALUES (555, 'Puskinova 13,Novi Sad,Srbija', 1250.00, 'Jankovic');	
	/*
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (4, 'Ticanova 1', 'Ruma', 'Srbija', '', 'ta.drcelic@gmail.com', false, false, 'Maja', 'Majic', '0654431123', 'Majic', 1);    
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (5, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', '', 'sava@gmail.com', false, false, 'Sava', 'Savic', '06541111123', 'Savic', 2);
*/

INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy_id)
	VALUES (4, 'Ticanova 1', 'Ruma', 'Srbija', '', 'ta.drcelic@gmail.com', false, false, 'Maja', 'Majic', '0654431123', 'Majic','majaa', 222);    
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy_id)
	VALUES (5, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', '', 'sava@gmail.com', false, false, 'Sava', 'Savic', '06541111123', 'Savic','sava',111);

/*
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (6, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', '', 'jovan.jovic838@gmail.com', false, false, 'Jovan', 'Jovic', '0632213455', 'Jovic');
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (7, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', '', 'lola@gmail.com', false, false, 'Lola', 'Lolic', '0632413455', 'Lola');
    */

INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (6, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', '', 'jovan.jovic838@gmail.com', false, false, 'Jovan', 'Jovic', '0632213455', 'Jovic','jokas');
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (7, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', '', 'lola@gmail.com', false, false, 'Lola', 'Lolic', '0632413455', 'Lola','neceViseLola');
    
    
	/*
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (8, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'marijavucetic@uns.ac.rs', false, false, 'Marija', 'Vucetic', '06581111123', 'Vucetic', 1);
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (9, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'toma@gmail.com', false, false, 'Toma', 'Tomic', '06581222123', 'Tomic', 2);
   */

INSERT INTO public.pharmacy_admin(

	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy)
	VALUES (8, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'marijavucetic@uns.ac.rs', false, false, 'Marija', 'Vucetic', '06581111123', 'Vucetic','maja', 'Feniks');
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy)
	VALUES (9, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'marijavucetic@uns.ac.rs', false, false, 'Toma', 'Tomic', '06581222123', 'Tomic','toma', 'Benu');
   
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (6, 111);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (7, 222);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (6, 222);

/*
INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (10, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'marija998v@gmail.com', false, false, 'Jelena', 'Jokic', '0632211124', 'Jokic');
INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (11, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', false, false, 'Goran', 'Goric', '0632211111', 'Goric');
    */


INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (10, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'ta.drcelic@gmail.com', false, false, 'Jelena', 'Jokic', '0632211124', 'Jokic','jeca');
INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (11, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'ta.drcelic@gmail.com', false, false, 'Goran', 'Goric', '0632211111', 'Goric','goran');

/*	
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (12, 'Boracka 29', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', true, false, 'Balsa', 'Balsic', '068444777', 'Balsic');
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (13, 'Cirpanova 9', 'Novi Sad', 'Srbija', '', 'gordana1@gmail.com', true, false, 'Gordana', 'Grbic', '068789654', 'Grbic');
*/
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (12, 'Boracka 29', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', true, false, 'Balsa', 'Balsic', '068444777', 'Balsic','balsa');
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (13, 'Cirpanova 9', 'Novi Sad', 'Srbija', '', 'gordana1@gmail.com', true, false, 'Gordana', 'Grbic', '068789654', 'Grbic','gordana');
    


INSERT INTO public.complaint(
	id, subject, text, patient_id,is_answered)
	VALUES (111, 'Jovan Jovic', 'neljubazan', 88,false);
INSERT INTO public.complaint(
	id, subject, text, patient_id,is_answered)
	VALUES (222, 'Sava Savic', 'neprofesionalan', 89,false);


INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (111, 1000.0, 'Headache', '2022-02-09 16:00:00-07', '2021-02-09 16:25:25-07', true, 88, 5, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (112, 2000.0, '', '2021-02-15 17:00:00-07', '2021-02-15 17:25:25-07', true, 89, 5, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (113, 1000.0, '', '2022-02-15 15:00:00-07', '2021-02-15 15:25:25-07', true, 88, 5, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (114, 2000.0, '', '2021-02-16 17:00:00-07', '2021-02-16 17:25:25-07', true, 89, 5, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (115, 1000.0, '', '2022-02-13 16:00:00-07', '2021-02-13 16:25:25-07', false, 88, 5, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (116, 2000.0, 'Headache', '2021-02-13 17:00:00-07', '2021-02-13 17:25:25-07', true, 89, 5, 222, false);
    
-- INSERT INTO public.eprescription(
-- 	code, issuing_date)
-- 	VALUES (111,'2016-06-22');
-- INSERT INTO public.eprescription(this.vacation.DateStart
-- 	code, issuing_date)
-- 	VALUES (112,'2017-06-22');
    
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (111, 500.0, '', '2021-02-09 19:10:25-07', '2021-02-09 19:20:25-07', false, 6, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (112, 1000.0, 'Headache and nausea', '2021-02-10 16:30:25-07', '2021-02-09 16:40:25-07', true, 6, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (113, 800.0, 'Headache and nausea', '2021-02-11 15:10:25-07', '2021-02-11 15:20:25-07', true, 6, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (114, 900.0, 'Headache and nausea', '2021-02-11 14:10:25-07', '2021-02-11 14:20:25-07', true, 6, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (115, 2000.0, '', '2021-02-13 15:10:25-07', '2021-02-13 15:20:25-07', true, 6, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id,is_canceled)
	VALUES (116, 3000.0, 'izvjestaj 2', '2021-08-13 18:00:25-07', '2021-08-13 18:10:25-07', false, 6, 88, 111,false);
    
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (117, 900.0, 'Headache and nausea', '2016-05-22 14:45:25-07', '2016-05-22 14:25:25-07', true, 6, 89, 111, false);

	
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (118, 500.0, '', '2021-02-15 19:10:25-07', '2021-02-15 19:20:25-07', false, 6, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (119, 1000.0, 'Headache and nausea', '2021-02-15 16:30:25-07', '2021-02-15 16:40:25-07', true, 6, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (120, 800.0, '', '2021-02-23 09:10:25-07', '2021-02-23 09:20:25-07', false, 6, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (121, 900.0, '', '2021-02-23 10:10:25-07', '2021-02-23 10:20:25-07', false, 6, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (122, 2000.0, '', '2021-02-12 15:10:25-07', '2021-02-12 15:20:25-07', true, 6, null, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (123, 3000.0, '', '2021-02-17 08:00:25-07', '2021-02-17 10:10:25-07', false, 6, 88, 222);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (124, 3000.0, '', '2021-02-17 11:00:25-07', '2021-02-17 11:10:25-07', false, 6, null, 222);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (125, 3000.0, '', '2021-02-17 12:00:25-07', '2021-02-17 12:10:25-07', false, 6, null, 222);
/*
INSERT INTO public.medicine(
	code, composition, form, manufacturer, name, note, on_prescription, type)
	VALUES (222, 'sastav 1', 3, 'galenika', 'brufen', 'napomena 1', true, 'analgetik');
INSERT INTO public.medicine(
	code, composition, form, manufacturer, name, note, on_prescription, type)
	VALUES (223, 'sastav 2', 4, 'hemofarm', 'amoksicilin','napomena 2', false, 'amoksicilin');
*/

  
INSERT INTO public.medicine(
id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (222,'222','/','Headache','2 per day',3,'Galenika','Brufen','/',true,5,5);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (223,'223','/','Headache','2 per day',4,'Hemofarm','Andol','/',false,7,7);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription,  points,type)
	VALUES (224,'224','/','Headache','3 per day',4,'Hemofarm','Klindomicin','/',false,8,7);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (4,230, 'sastav', 'nema', '5', 1, 'Galenika', 'Gentamicin', ' ', false,1, 3);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (5,231, 'sastav', 'nema', '5', 2, 'Galenika', 'Alopurinol', ' ', false, 2,7);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (6,232, 'sastav', 'nema', '5', 6, 'Galenika', 'Monopril', '/', true,1, 4);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (7,233, 'sastav', 'nema', '5', 3, 'Galenika', 'Amoksicilin', '/', true,4, 8);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription,  points,type)
	VALUES (8,234, 'sastav', 'nema', '5', 6, 'Hemofarm', 'Probiotik', '/', false, 3,9);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (9,235, 'sastav', 'nema', '5', 4, 'Hemofarm', 'Defrinol', '/', false, 3,7);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (10,236, 'sastav', 'nema', '5', 2, 'Hemofarm', 'Diklofen', '/', true, 4,5);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (11,237, 'sastav', 'nema', '5', 1, 'Hemofarm', 'Enterofuryl', '/', false,6, 1);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (12,238, 'sastav', 'nema', '5', 2, 'Hemofarm', 'Hylocomod', '/', false,9, 3);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (13,239, 'sastav', 'nema', '5', 5, 'Hemofarm', 'Nolpaza', '/', false,6, 4);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription,  points,type)
	VALUES (14,240, 'sastav', 'nema', '5', 4, 'Hemofarm', 'Cornelin', '/', true, 4,8);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, points, type)
	VALUES (15,241, 'sastav', 'nema', '5', 3, 'Hemofarm', 'Presing', '/', true, 6,9);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription,  points,type)
	VALUES (16,242, 'sastav', 'nema', '5', 2, 'Hemofarm', 'Rapidol', '/', false, 4,8);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription,  points,type)
	VALUES (17,243, 'sastav', 'nema', '5', 1, 'Hemofarm', 'Fursemid', '/', false, 3,9);


INSERT INTO public.action_or_promotion(
	id, text, medicine_id, pharmacy_id)
	VALUES (222, 'akcija 50%', 222,  111);
INSERT INTO public.action_or_promotion(
	id, text, medicine_id, pharmacy_id)
	VALUES (223, 'akcija 30%', 223, 111);


INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (1, 250.0, 3, 222);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (2, 200.0, 3, 223);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (3, 200.0, 5, 223);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (4, 200.0, 5, 222);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (5, 200.0, 4, 224);

-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 0);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 2);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 4);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 1);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 5);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 4);



INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (1, 5, 222, 10);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (2, 10, 223, 11);
	INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (4, 5, 5, 10);
	INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (6, 350.00, 7, 5);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (7, 370.00, 5, 6);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (8, 375.00, 4, 6);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (55, 375.00, 10, 6);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (56, 780.00, 3, 12);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (9, 380.00, 2, 7);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (10, 385.00, 5, 7);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (11, 385.00,3 , 8);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (12, 460.00,3, 9);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (13, 465.00,3, 10);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (14, 435.00,10, 10);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (15, 700.00,10, 11);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (18, 495.00,2, 4);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (19, 495.00,4, 4);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (24, 535.00,3, 15);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (25, 520.00,2, 15);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (22, 585.00,1, 14);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (23, 530.00,3, 14);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (20, 485.00,2, 13);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (21, 440.00,4, 13);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (26, 215.00,3, 16);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (27, 2150.00,2, 16);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (28, 235.00,3, 17);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (29, 250.00,2, 17);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (77, 235.00, 15, 15);
    
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (88, 'brufen');
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (88, 'cefalosporini');
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (89, 'tetraciklini');
    
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (4, 4);
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (4, 2);
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (4, 1);
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (5, 2);
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (5, 4);
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (5, 2);
    
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (111, 4);
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (111, 5);
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (111, 1);
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (222, 4);
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (222, 2);
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (222, 1);
    
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (100, '2021-03-22', false, 1, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (101, '2021-03-22', true, 2, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (102, '2021-05-12', false, 2, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (103, '2020-03-22', false, 2, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (104, '2021-01-22', false, 2, 88, 111, false);
    

-- INSERT INTO public.therapy(
-- 	id, amount, therapy_duration, medicine_id)
-- 	VALUES (1, 2, 5, 222);
-- INSERT INTO public.therapy(
-- 	id, amount, therapy_duration, medicine_id)
-- 	VALUES (2, 3, 12, 223);
    
-- INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (88, 111);
-- INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (88, 222);
-- INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (89, 111);
-- INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (90, 222);


INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (111, true, '2021-02-12', '2021-02-12');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (112, true, '2021-02-22','2021-02-18');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (113, true, '2021-02-22', '2021-02-19');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (114, true, '2021-01-29', '2021-01-19');


INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (6, 111);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (6, 112);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (7, 113);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (6, 114);

INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (4, 111);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (5, 112);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (5, 114);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (4, 113);

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (111, '2021-02-09 20:00:00-07','2021-02-09 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (112, '2021-02-10 20:00:00-07','2021-02-10 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (113, '2021-02-11 20:00:00-07','2021-02-11 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (114, '2021-02-12 20:00:00-07','2021-02-12 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (115, '2021-02-13 20:00:00-07','2021-02-13 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (116, '2021-02-14 20:00:00-07','2021-02-14 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (117, '2021-02-15 20:00:00-07','2021-02-15 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (118, '2021-02-16 20:00:00-07','2021-02-16 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (119, '2021-02-17 20:00:00-07','2021-02-17 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (120, '2021-02-23 20:00:00-07','2021-02-23 14:00:00-07','111');

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (211, '2021-02-09 15:00:00-07','2021-02-09 07:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (212, '2021-02-10 14:00:00-07','2021-02-10 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (213, '2021-02-11 15:00:00-07','2021-02-11 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (214, '2021-02-12 14:00:00-07','2021-02-12 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (215, '2021-02-13 15:00:00-07','2021-02-13 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (216, '2021-02-14 14:00:00-07','2021-02-14 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (217, '2021-02-15 14:00:00-07','2021-02-15 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (218, '2021-02-16 15:00:00-07','2021-02-16 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (219, '2021-02-17 14:00:00-07','2021-02-17 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (220, '2021-02-23 15:00:00-07','2021-02-23 08:00:00-07','222');

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 111);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 112);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 213);
	INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 115);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 116);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 117);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 219);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 220);

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (7, 112);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (4, 112);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (5, 111);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (5, 114);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (5, 115);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (4, 115);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (5, 116);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (5, 117);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (5, 118);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (5, 119);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (5, 120);
-- INSERT INTO public.pharmacist_working_schedule(
-- 	pharmacist_id, working_time_id)
-- 	VALUES (5, 111);

-- INSERT INTO public.eprescription_therapies(
-- 	eprescription_code, therapies_id)
-- 	VALUES (111, 1);
-- INSERT INTO public.eprescription_therapies(
-- 	eprescription_code, therapies_id)
-- 	VALUES (112, 2);

INSERT INTO public.eprescription(
	code, issuing_date,therapy_duration, medicine_id,status,pharmacy_id)
	VALUES (111,'2016-10-09',2,1,0,111);
INSERT INTO public.eprescription(
	code, issuing_date,therapy_duration, medicine_id,status,pharmacy_id)
	VALUES (112,'2017-06-22',2,2,1,111);

INSERT INTO public.patient_eprescriptions(
	patient_id, eprescriptions_code)
	VALUES (88, 111);
INSERT INTO public.patient_eprescriptions(
	patient_id, eprescriptions_code)
	VALUES (88, 112);
-- INSERT INTO public.pharmacy_list_actions_or_promotions(
-- 	pharmacy_id, list_actions_or_promotions_id)
-- 	VALUES (1, 11);
-- INSERT INTO public.pharmacy_list_actions_or_promotions(
-- 	pharmacy_id, list_actions_or_promotions_id)
-- 	VALUES (2, 12);



INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 1);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 3);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 2);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 4);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 5);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 18);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (333, 19);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 24);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (333, 10);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (333, 11);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (333, 28);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (333, 26);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 6);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 12);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (333, 13);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 14);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (555, 21);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 23);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (555, 25);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 8);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 9);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 15);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 20);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 27);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 29);

INSERT INTO public.medicine_replacement(
	medicine_id, replacement)
	VALUES (222, 'sinacilin');
INSERT INTO public.medicine_replacement(
	medicine_id, replacement)
	VALUES (223, 'panadol');

INSERT INTO public.patient_action_or_promotions(
	patient_id, action_or_promotions_id)
	VALUES (88, 222);
INSERT INTO public.patient_action_or_promotions(
	patient_id, action_or_promotions_id)
	VALUES (88, 223);

INSERT INTO public.pharmacy_subscribed_users(
pharmacy_id,patient_id)
VALUES('111','88');

INSERT INTO public.pharmacy_subscribed_users(
pharmacy_id,patient_id)
VALUES('111','69');

INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (500, 4, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (501, 1, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (502, 2, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (503, 3, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (504, 5, 89);

INSERT INTO public.medicine_marks(
	medicine_id, marks_id)
	VALUES (222, 500);
INSERT INTO public.medicine_marks(
	medicine_id, marks_id)
	VALUES (223, 504);
INSERT INTO public.medicine_marks(
	medicine_id, marks_id)
	VALUES (224, 503);

INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (5, 501);



	
INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id)
	VALUES (1,'2008-11-11 13:23:44', 8);
	
INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id)
	VALUES (2,'2008-11-11 13:23:44', 9);

INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id)
	VALUES (3,'2008-11-11 13:23:44', 8);

INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (2, 1);
INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (2, 2);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (3, 3, 223, 10);
INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (3, 3);


	INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (557, 'neki datum', 14000.00, 2, 3, 10);
	
	INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (556, 'neki datum', 15000.00, 1, 2, 10);
	
	INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (555, 'neki datum', 16000.00, 0, 1, 10);

	INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (32, 300.00, 4, 223);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (33, 300.00, 4, 222);
	
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (35, 300.00, 4, 223);

INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (34, 300.00, 4, 222);

INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (39, 300.00, 4, 224);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 32);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 33);



	INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 39);
	INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (555, 56);
	INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 55);

INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks_id)
	VALUES (222, 500);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks_id)
	VALUES (333, 503);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks_id)
	VALUES (444, 501);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks_id)
	VALUES (555, 502);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 77);
INSERT INTO public.loyalty_programme(
	id, gold, points_for_counceling, points_for_examination, regular, silver)
	VALUES (1, 75, 10, 10, 50, 25);