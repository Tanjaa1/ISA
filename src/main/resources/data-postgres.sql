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
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, penalty, points)
	VALUES (88, 'Mileve Maric 5', 'Novi Sad', 'Srbija', '', 'aleksarep0408@gmail.com', false, false, 'Jovana', 'Jovanic', '0628876678', 'Jovanic','jocas', 0, 0, 0);
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, penalty, points)
	VALUES (89, 'Glavna 100', 'Ruma', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Sara', 'Saric', '0648816428', 'Saric','sara', 0, 0, 0);
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, penalty, points)
	VALUES (90, 'Lenjinova 20', 'Ruma', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Luka', 'Lukic', '0612334555', 'Lukic','luka',0, 0, 0);
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, penalty, points)
	VALUES (69, 'Синђелићева 44', 'Нови Сад', 'Србија', '', 'aleksarep0408@gmail.com', false, false, 'Aлекса', 'sifra', '0612334555', 'Реповић','aleksarep',0, 0, 0);

INSERT INTO public.pharmacy(id, address, name, counseling_price) VALUES (111, 'Stanoja Stanojevica 4,Novi Sad,Srbija', 'Feniks', 1000.0);
INSERT INTO public.pharmacy(id, address, name, counseling_price) VALUES (222, 'Maksima Gorkog 44,Novi Sad,Srbija', 'Benu', 2000.0);

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
	VALUES (4, 'Ticanova 1', 'Ruma', 'Srbija', '', 'ta.drcelic@gmail.com', false, false, 'Maja', 'Majic', '0654431123', 'Majic','majaa', 111);    
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy_id)
	VALUES (5, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', '', 'sava@gmail.com', false, false, 'Sava', 'Savic', '06541111123', 'Savic','sava',222);

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
	VALUES (8, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'marijavucetic@uns.ac.rs', false, false, 'Marija', 'Vucetic', '06581111123', 'Vucetic','maja', 'Jankovic');
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy)
	VALUES (9, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'toma@gmail.com', false, false, 'Toma', 'Tomic', '06581222123', 'Tomic','toma', 'Benu');
   
   
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (6, 111);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (7, 222);

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
	VALUES (10, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'marija998v@gmail.com', false, false, 'Jelena', 'Jokic', '0632211124', 'Jokic','jeca');
INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (11, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', false, false, 'Goran', 'Goric', '0632211111', 'Goric','goran');

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
	VALUES (111, 1000.0, 'izvjestaj 1', '2016-06-22 19:10:25-07', '2016-06-22 19:20:25-07', true, 88, 5, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (112, 2000.0, 'izvjestaj 1', '2017-03-30 12:20:25-07', '2017-03-30 12:30:25-07', true, 88, 5, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (113, 800.0, 'izvjestaj 1', '2021-06-22 19:10:25-07', '2021-06-22 19:20:25-07', true, 88, 5, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (114, 500.0, 'izvjestaj 1', '2021-08-08 09:00:25-07', '2021-08-08 09:20:00-07', true, 88, 5, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (115, 2000.0, 'izvjestaj 2', '2016-06-22 19:10:25-07', '2016-06-22 19:20:25-07', true, 90, 5, 222, false);
    
-- INSERT INTO public.eprescription(
-- 	code, issuing_date)
-- 	VALUES (111,'2016-06-22');
-- INSERT INTO public.eprescription(this.vacation.DateStart
-- 	code, issuing_date)
-- 	VALUES (112,'2017-06-22');
    
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (111, 500.0, 'izvjestaj 1', '2016-06-22 19:10:25-07', '2016-06-22 19:20:25-07', true, 6, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (112, 1000.0, 'izvjestaj 1', '2018-12-03 10:30:25-07', '2016-06-22 10:40:25-07', true, 6, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (113, 800.0, 'izvjestaj 1', '2021-06-22 19:10:25-07', '2016-06-22 19:20:25-07', true, 6, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (114, 900.0, 'izvjestaj 1', '2021-10-11 14:15:25-07', '2016-06-22 14:25:25-07', true, 6, 88, 111, false);
	
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (115, 2000.0, 'izvjestaj 2', '2016-07-22 19:10:25-07', '2016-06-22 19:20:25-07', true, 6, null, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (116, 3000.0, 'izvjestaj 2', '2021-08-13 18:00:25-07', '2021-08-13 18:10:25-07', false, 6, null, 111);
    
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (117, 900.0, 'izvjestaj 1', '2016-05-22 14:45:25-07', '2016-05-22 14:25:25-07', true, 6, 89, 111, false);
	
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (118, 900.0, 'izvjestaj 1', '2021-02-13 09:00:00-07', '2016-05-22 14:25:25-07', true, 6, 89, 111, false);	
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (119, 900.0, 'izvjestaj 1', '2021-02-10 16:00:00-07', '2016-05-22 14:25:25-07', true, 6, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (120, 900.0, 'izvjestaj 1', '2021-02-10 16:00:00-07', '2016-05-22 14:25:25-07', true, 6, 88, 111, false);
/*
INSERT INTO public.medicine(
	code, composition, form, manufacturer, name, note, on_prescription, type)
	VALUES (222, 'sastav 1', 3, 'galenika', 'brufen', 'napomena 1', true, 'analgetik');
INSERT INTO public.medicine(
	code, composition, form, manufacturer, name, note, on_prescription, type)
	VALUES (223, 'sastav 2', 4, 'hemofarm', 'amoksicilin','napomena 2', false, 'amoksicilin');
*/

  
INSERT INTO public.medicine(
id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, type)
	VALUES (222,'bjs4fs','neki sastav','neke kontraindikacije','neka dnevna doza',3,'Galenika','Brufen','neka napomena',true,5);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, type)
	VALUES (223,'sjhf4w','neki sastav20','neke kontraindikacije 2','neka dnevna doza',4,'Hemofarm','Andol','neka napomena 2',false,7);


INSERT INTO public.action_or_promotion(
	id, text, medicine_id, pharmacy_id)
	VALUES (222, 'akcija 50%', 222,  111);
INSERT INTO public.action_or_promotion(
	id, text, medicine_id, pharmacy_id)
	VALUES (223, 'akcija 30%', 223, 111);


INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (1, 250.0, 20, 222);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (2, 200.0, 30, 223);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (3, 200.0, 30, 223);

INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 0);
INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 1);



INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (13123, 5, 222, 10);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (2312312, 10, 223, 11);
    
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (88, 'paracetamol');
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (88, 'cefalosporini');
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (89, 'tetraciklini');
    
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks)
	VALUES (4, 4);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks)
	VALUES (4, 2);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks)
	VALUES (4, 1);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks)
	VALUES (5, 2);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks)
	VALUES (5, 4);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks)
	VALUES (5, 2);
    
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (111, 4);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (111, 5);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (111, 1);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (222, 4);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (222, 2);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (222, 1);
    
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (1, '2021-03-22', false, 1, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (2, '2021-03-22', true, 2, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (3, '2021-05-12', false, 2, 89, 111, false);
    

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
	VALUES (111, false, '2021-02-12', '2021-02-12');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (112, false, '2021-02-22','2021-02-15');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (113, false, '2021-05-22', '2021-05-15');


INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (6, 111);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (6, 112);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (7, 113);

INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (4, 111);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (5, 112);

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1, '2021-06-22 08:00:00-07', '2021-06-22 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (2, '2021-06-24 14:00:00-07', '2021-06-24 20:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (3, '2021-06-23 14:00:00-07', '2021-06-23 20:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (4, '2000-06-23 14:00:00-07', '2003-06-23 20:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (111, '2016-06-24 20:00:00-07', '2017-06-24 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (112, '2021-06-24 20:00:00-07', '2021-06-24 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (113, '2021-06-23 20:00:00-07', '2021-06-23 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (114, '2021-02-12 14:00:00-07', '2021-02-12 08:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (115, '2021-02-13 20:00:00-07','2021-02-13 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (116, '2021-02-10 20:00:00-07','2021-02-10 14:00:00-07','111');



INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 111);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 112);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 114);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 115);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)

	VALUES (6, 4);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (7, 2);
	VALUES (6, 116);

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (7, 112);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (4, 112);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (5, 111);


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