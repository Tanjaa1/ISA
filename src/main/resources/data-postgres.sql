INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, category, penalty, points)
	VALUES (1, 'Mileve Maric 5', 'Novi Sad', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Jovana', 'Jovanic', '0628876678', 'Jovanic', 0, 0, 0);
    
INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, category, penalty, points)
	VALUES (2, 'Glavna 100', 'Ruma', 'Srbija', '', 'sara@gmail.com', false, false, 'Sara', 'Saric', '0648816428', 'Saric', 0, 0, 0);
INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, category, penalty, points)
	VALUES (3, 'Lenjinova 20', 'Ruma', 'Srbija', '', 'aleksandramilijevic98@gmail', false, false, 'Luka', 'Lukic', '0612334555', 'Lukic', 0, 0, 0);


INSERT INTO public.pharmacy(id, address, name) VALUES (1, 'Stanoja Stanojevica 4,Novi Sad,Srbija', 'Feniks');
INSERT INTO public.pharmacy(id, address, name) VALUES (2, 'Maksima Gorkog 44,Novi Sad,Srbija', 'Benu');

    
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (4, 'Ticanova 1', 'Ruma', 'Srbija', '', 'ta.drcelic@gmail.com', false, false, 'Maja', 'Majic', '0654431123', 'Majic', 1);    
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (5, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', '', 'sava@gmail.com', false, false, 'Sava', 'Savic', '06541111123', 'Savic', 2);


INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (6, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', '', 'jovan.jovic838@gmail.com', false, false, 'Jovan', 'Jovic', '0632213455', 'Jovic');
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (7, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', '', 'lola@gmail.com', false, false, 'Lola', 'Lolic', '0632413455', 'Lola');
    
    
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (8, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'marijavucetic@uns.ac.rs', false, false, 'Marija', 'Vucetic', '06581111123', 'Vucetic', 1);
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (9, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'toma@gmail.com', false, false, 'Toma', 'Tomic', '06581222123', 'Tomic', 2);
   
   
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (6, 1);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (7, 2);


INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (10, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'marija998v@gmail.com', false, false, 'Jelena', 'Jokic', '0632211124', 'Jokic');
INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (11, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', false, false, 'Goran', 'Goric', '0632211111', 'Goric');
    
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (12, 'Boracka 29', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', true, false, 'Balsa', 'Balsic', '068444777', 'Balsic');
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (13, 'Cirpanova 9', 'Novi Sad', 'Srbija', '', 'gordana1@gmail.com', true, false, 'Gordana', 'Grbic', '068789654', 'Grbic');
    
INSERT INTO public.complaint(
	id, subject, text, patient_id)
	VALUES (1, 'Jovan Jovic', 'neljubazan', 2);
INSERT INTO public.complaint(
	id, subject, text, patient_id)
	VALUES (2, 'Sava Savic', 'neprofesionalan', 3);
    
INSERT INTO public.complaint_answer(
	id, text, complaint_id, system_admin_id)
	VALUES(1, 'odgovor na zalbu jedan', 1, 12);
INSERT INTO public.complaint_answer(
	id, text, complaint_id, system_admin_id)
	VALUES(2, 'odgovor na zalbu dva', 2, 13);

INSERT INTO public.counseling(
	id, report, start_time, is_done, patient_id, pharmacist_id, pharmacy_id)
	VALUES (1, 'izvjestaj 1', '2016-06-22 19:10:25-07', true, 1, 5, 2);
INSERT INTO public.counseling(
	id, report, start_time, is_done, patient_id, pharmacist_id, pharmacy_id)
	VALUES (2, 'izvjestaj 1', '2021-06-22 19:10:25-07', true, 1, 5, 2);
INSERT INTO public.counseling(
	id, report, start_time, is_done, patient_id, pharmacist_id, pharmacy_id)
	VALUES (3, 'izvjestaj 2', '2016-06-22 19:10:25-07', true, 3, 5, 2);
    
INSERT INTO public.eprescription(
	code, issuing_date)
	VALUES (111,'2016-06-22');
INSERT INTO public.eprescription(
	code, issuing_date)
	VALUES (112,'2017-06-22');
    
INSERT INTO public.examination(
	id, report, start_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (1, 'izvjestaj 1', '2016-06-22 19:10:25-07', true, 6, 1, 1);
INSERT INTO public.examination(
	id, report, start_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (2, 'izvjestaj 1', '2021-06-22 19:10:25-07', true, 6, 1, 1);
INSERT INTO public.examination(
	id, report, start_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (3, 'izvjestaj 2', '2016-07-22 19:10:25-07', true, 6, 3, 1);
    
INSERT INTO public.medicine(
	code, composition, form, manufacturer, name, note, on_prescription, type)
	VALUES (222, 'sastav 1', 3, 'galenika', 'brufen', 'napomena 1', true, 'analgetik');
INSERT INTO public.medicine(
	code, composition, form, manufacturer, name, note, on_prescription, type)
	VALUES (223, 'sastav 2', 4, 'hemofarm', 'amoksicilin','napomena 2', false, 'amoksicilin');
    
INSERT INTO public.action_or_promotion(
	id, text, medicine_code, pharmacy_id)
	VALUES (11, 'akcija 50%', 222,  1);
INSERT INTO public.action_or_promotion(
	id, text, medicine_code, pharmacy_id)
	VALUES (12, 'akcija 30%', 223, 1);


INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_code)
	VALUES (1, 250.0, 20, 222);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_code)
	VALUES (2, 200.0, 30, 223);

INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 0);
INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 1);

INSERT INTO public.order_medicine(id, due_date, pharmacy_admin_id) VALUES (1, '2021-06-22', 8);
INSERT INTO public.order_medicine(id, due_date, pharmacy_admin_id) VALUES (2, '2021-02-22', 9);

INSERT INTO public.medicine_quantity(
	id, quantity, medicine_code, supplier_id)
	VALUES (1, 5, 222, 10);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_code, supplier_id)
	VALUES (2, 10, 223, 11);
    
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (1, 'penicilin');
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (1, 'cefalosporini');
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (2, 'tetraciklini');
    
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
	VALUES (1, 4);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (1, 5);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (1, 1);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (2, 4);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (2, 2);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks)
	VALUES (2, 1);
    
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id)
	VALUES (1, '2021-03-22', false, 1, 1, 1);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id)
	VALUES (2, '2021-05-12', false, 2, 2, 1);
    
INSERT INTO public.supplier_offer(
	id, offer_price, is_accepted, order_medicine_id, supplier_id)
	VALUES (1, 250.0, false, 1, 10);
INSERT INTO public.supplier_offer(
	id, offer_price, is_accepted, order_medicine_id, supplier_id)
	VALUES (2, 400.0, false, 2, 11);
    
INSERT INTO public.therapy(
	id, amount, therapy_duration, medicine_code)
	VALUES (1, 2, 5, 222);
INSERT INTO public.therapy(
	id, amount, therapy_duration, medicine_code)
	VALUES (2, 3, 12, 223);
    
INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (1, 1);
INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (2, 2);
INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (3, 1);
INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (1, 2);


INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (1, false, '2021-03-12', '2021-03-22');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (2, false, '2021-04-12', '2021-04-22');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (3, false, '2021-05-12', '2021-05-22');


INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (6, 1);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (6, 2);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (7, 3);

INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (4, 1);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (5, 2);

INSERT INTO public.working_time(
	id, time_end, time_start)
	VALUES (1, '2021-06-22 08:00:00-07', '2021-06-22 14:00:00-07');
INSERT INTO public.working_time(
	id, time_end, time_start)
	VALUES (2, '2021-06-24 14:00:00-07', '2021-06-24 20:00:00-07');
INSERT INTO public.working_time(
	id, time_end, time_start)
	VALUES (3, '2021-06-23 14:00:00-07', '2021-06-23 20:00:00-07');

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 1);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (6, 2);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (7, 2);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (4, 2);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (5, 1);

INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (1, 2);
INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (2, 1);

INSERT INTO public.eprescription_therapies(
	eprescription_code, therapies_id)
	VALUES (111, 1);
INSERT INTO public.eprescription_therapies(
	eprescription_code, therapies_id)
	VALUES (112, 2);

INSERT INTO public.patient_eprescriptions(
	patient_id, eprescriptions_code)
	VALUES (1, 111);
INSERT INTO public.patient_eprescriptions(
	patient_id, eprescriptions_code)
	VALUES (1, 112);

-- INSERT INTO public.pharmacy_list_actions_or_promotions(
-- 	pharmacy_id, list_actions_or_promotions_id)
-- 	VALUES (1, 11);
-- INSERT INTO public.pharmacy_list_actions_or_promotions(
-- 	pharmacy_id, list_actions_or_promotions_id)
-- 	VALUES (2, 12);

INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (1, 1);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (2, 2);

INSERT INTO public.medicine_replacement(
	medicine_code, replacement)
	VALUES (222, 'sinacilin');
INSERT INTO public.medicine_replacement(
	medicine_code, replacement)
	VALUES (223, 'panadol');