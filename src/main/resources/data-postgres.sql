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
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, category, points)
	VALUES (88, 'Mileve Maric 5', 'Novi Sad', 'Srbija', '', 'marijavucetic66@gmail.com', true, false, 'Jovana', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0628876678', 'Jovanic',true,'2008-11-11 13:23:44','jocas', 0, 27);
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (88, 'Mileve Maric 5', 'Novi Sad', 'Srbija', '', 'marijavucetic66@gmail.com', true, false, 'Jovana', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','584545878','Jovanic',true,'2008-11-11 13:23:44','jocas');

INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, category, points)
	VALUES (89, 'Glavna 100', 'Ruma', 'Srbija', 'neki opis', 'marijavucetic66@gmail.com', true, false, 'Sara', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0648816428', 'Saric',true,'2008-11-11 13:23:44','sara', 0, 7);
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (89, 'Glavna 100', 'Ruma', 'Srbija', '', 'marijavucetic66@gmail.com', true, false, 'Sara', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','0648816428','Saric',true, '2008-11-11 13:23:44', 'sara');
	
INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, category, points)
	VALUES (90, 'Lenjinova 20', 'Ruma', 'Srbija', 'neki opis', 'marijavucetic66@gmail.com', false, false, 'Luka','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0612334555', 'Lukic',true,'2008-11-11 13:23:44','luka',0, 0);
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (90, 'Lenjinova 20', 'Ruma', 'Srbija', 'neki opis', 'marijavucetic66@gmail.com', false, false, 'Luka', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0612334555', 'Lukic',true,'2008-11-11 13:23:44','luka');

	

INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, category, points)
	VALUES (69, 'Синђелићева 44', 'Нови Сад', 'Србија', 'neki opis', 'ta.drcelic@gmail.com', false, false, 'Aлекса', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0612334555', 'Реповић',true,'2008-11-11 13:23:44','aleksarep',0, 0);
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (69, 'Синђелићева 44', 'Нови Сад', 'Србија', 'neki opis', 'ta.drcelic@gmail.com', false, false, 'Aлекса', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0612334555', 'Реповић',true,'2008-11-11 13:23:44','aleksarep');
INSERT INTO public.pharmacy(id, address, name, counseling_price) VALUES (111, 'Bulevar Patrijarha Pavla 30,Novi Sad,Srbija', 'Feniks', 1000.0);
INSERT INTO public.pharmacy(id, address, name, counseling_price) VALUES (222, 'Lasla Gala 26,Novi Sad,Srbija', 'Benu', 2000.0);
INSERT INTO public.pharmacy(id, address, counseling_price, name)VALUES (333, 'Bulevar Oslobodjenja 15,Novi Sad,Srbija', 500.00, 'Sunce');
INSERT INTO public.pharmacy(id, address, counseling_price, name)VALUES (444, 'Sekspirova 10,Novi Sad,Srbija', 1200.00, 'Heba');   
INSERT INTO public.pharmacy(id, address, counseling_price, name)VALUES (555, 'Puskinova 13,Novi Sad,Srbija', 1250.00, 'Jankovic');	
INSERT INTO public.map_location(
	id,x,y,pharmacy_id)
	VALUES (57,19.832260,45.262570,333);
INSERT INTO public.map_location(
	id,x,y,pharmacy_id)
	VALUES (58,19.836180,45.240950,444);
INSERT INTO public.map_location(
	id,x,y,pharmacy_id)
	VALUES (59,19.833070,45.245210,555);
	
	/*
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (4, 'Ticanova 1', 'Ruma', 'Srbija', '', 'ta.drcelic@gmail.com', false, false, 'Maja', 'Majic', '0654431123', 'Majic', 1);    
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (5, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', '', 'sava@gmail.com', false, false, 'Sava', 'Savic', '06541111123', 'Savic', 2);
*/

INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, pharmacy_id)
	VALUES (444, 'Ticanova 1', 'Ruma', 'Srbija', 'neki opis', 'ta.drcelic@gmail.com', true, false, 'Maja', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0654431123', 'Majic',true,'2008-11-11 13:23:44','majaa', 222);    
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (444, 'Ticanova 1', 'Ruma', 'Srbija', 'neki opis', 'ta.drcelic@gmail.com', false, false, 'Maja', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0654431123', 'Majic',true,'2008-11-11 13:23:44','majaa');    
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, pharmacy_id)
	VALUES (555, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Sava', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06541111123', 'Savic',true,'2008-11-11 13:23:44','sava',111);
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (555, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Sava', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06541111123', 'Savic',true,'2008-11-11 13:23:44','sava');

/*
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (6, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', '', 'jovan.jovic838@gmail.com', false, false, 'Jovan', 'Jovic', '0632213455', 'Jovic');
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (7, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', '', 'lola@gmail.com', false, false, 'Lola', 'Lolic', '0632413455', 'Lola');
    */

INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (66, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', true, false, 'Jovan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632213455', 'Jovic',true,'2008-11-11 13:23:44','jokas');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (66, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Jovan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632213455', 'Jovic',true,'2008-11-11 13:23:44','jokas');
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (77, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Lola', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632413455', 'Lola',true,'2008-11-11 13:23:44','neceViseLola');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (77, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Lola', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632413455', 'Lola',true,'2008-11-11 13:23:44','neceViseLlola');

    
	/*
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (8, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'marijavucetic@uns.ac.rs', false, false, 'Marija', 'Vucetic', '06581111123', 'Vucetic', 1);
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (9, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'toma@gmail.com', false, false, 'Toma', 'Tomic', '06581222123', 'Tomic', 2);
   */

INSERT INTO public.pharmacy_admin(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, pharmacy)
	VALUES (888, 'Stevana Sindjelica 66', 'Novi Sad', 'Srbija', 'neki opis', 'marijavucetic@uns.ac.rs', true, true, 'Marija', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06581111123', 'Vucetic',true,'2008-11-11 13:23:44','maja', 'Feniks');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (888, 'Stevana Sindjelica 66', 'Novi Sad', 'Srbija', 'neki opis', 'marijavucetic@uns.ac.rs', true, true, 'Marija', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06581111123', 'Vucetic',true,'2008-11-11 13:23:44','maja');
INSERT INTO public.pharmacy_admin(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, pharmacy)
	VALUES (333, 'Stevana Sindjelica 66', 'Novi Sad', 'Srbija', 'neki opis', 'marijavucetic@uns.ac.rs', true, true, 'Pera', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06581111123', 'Peric',true,'2008-11-11 13:23:44','pera', 'Feniks');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (333, 'Stevana Sindjelica 66', 'Novi Sad', 'Srbija', 'neki opis', 'marijavucetic@uns.ac.rs', true, true, 'Pera', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06581111123', 'Peric',true,'2008-11-11 13:23:44','pera');

INSERT INTO public.pharmacy_admin(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, pharmacy)
	VALUES (999, 'Laze Kostica 43', 'Novi Sad', 'Srbija', 'neki opis', 'marijavucetic@uns.ac.rs', false, true, 'Toma', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06581222123', 'Tomic',true,'2008-11-11 13:23:44','toma', 'Benu');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (999, 'Laze Kostica 53', 'Novi Sad', 'Srbija', 'neki opis', 'marijavucetic@uns.ac.rs', false, true, 'Toma', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06581222123', 'Tomic',true,'2008-11-11 13:23:44','toma');


INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (66, 111);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (77, 222);


INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (66, 222);
 
/*
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (61, 111);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (61, 222);
*/
/*
INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (10, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'marija998v@gmail.com', false, false, 'Jelena', 'Jokic', '0632211124', 'Jokic');
INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (11, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', false, false, 'Goran', 'Goric', '0632211111', 'Goric');
    */


INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (100, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'ta.drcelic@gmail.com', true, true, 'Jelena', '123', '0632211124', 'Jokic',true,'2008-11-11 13:23:44','jeca');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (100, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'ta.drcelic@gmail.com', true, true, 'Jelena', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632211124', 'Jokic',true,'2008-11-11 13:23:44','jeca');


INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (111, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'ta.drcelic@gmail.com', true, true, 'Goran','123', '0632211111', 'Goric',true,'2008-11-11 13:23:44','goran');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (111, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'ta.drcelic@gmail.com', true, true, 'Goran', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632211111', 'Goric',true,'2008-11-11 13:23:44','goran');
/*	
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (12, 'Boracka 29', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', true, false, 'Balsa', 'Balsic', '068444777', 'Balsic');
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (13, 'Cirpanova 9', 'Novi Sad', 'Srbija', '', 'gordana1@gmail.com', true, false, 'Gordana', 'Grbic', '068789654', 'Grbic');
*/
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (122, 'Boracka 29', 'Novi Sad', 'Srbija', 'neki opis', 'goran@gmail.com', true, true, 'Balsa', '123', '068444777', 'Balsic',true,'2008-11-11 13:23:44','balsa');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (122, 'Boracka 29', 'Novi Sad', 'Srbija', 'neki opis', 'goran@gmail.com', true, true, 'Balsa', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '068444777', 'Balsic',true,'2008-11-11 13:23:44','balsa');


INSERT INTO public.complaint(
	id, subject, text, patient_id,is_answered)
	VALUES (111, 'Jovan Jovic', 'neljubazan', 88,false);
INSERT INTO public.complaint(
	id, subject, text, patient_id,is_answered)
	VALUES (222, 'Sava Savic', 'neprofesionalan', 89,false);


INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (111, 1000.0, '', '2022-06-17 16:00:00-07', '2021-06-17 16:25:25-07', false, 88, 444, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (112, 2000.0, '', '2021-06-11 17:00:00-07', '2021-06-11 17:25:25-07', false, 89, 444, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (113, 1000.0, '', '2022-06-11 15:00:00-07', '2021-06-11 15:25:25-07', false, 88, 444, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (114, 2000.0, '', '2021-07-16 17:00:00-07', '2021-07-16 17:25:25-07', false, null, 444, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (115, 1000.0, '', '2022-06-15 16:00:00-07', '2021-06-15 16:25:25-07', false, null, 444, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (116, 2000.0, '', '2021-06-16 17:00:00-07', '2021-06-16 17:25:25-07', false, null, 444, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (216, 2000.0, '', '2021-06-11 11:30:00-07', '2021-06-11 12:00:25-07', false, 89, 444, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (316, 2000.0, '', '2021-06-07 11:30:00-07', '2021-06-07 12:00:25-07', false, 89, 444, 222, false);
	
-- INSERT INTO public.eprescription(
-- 	code, issuing_date)
-- 	VALUES (111,'2016-06-22');
-- INSERT INTO public.eprescription(this.vacation.DateStart
-- 	code, issuing_date)
-- 	VALUES (112,'2017-06-22');
    
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (111, 500.0, 'Headache and nausea', '2021-06-06 19:10:25-07', '2021-06-06 19:20:25-07', true, 66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (112, 1000.0, '', '2021-07-10 16:30:25-07', '2021-07-10 16:40:25-07', true, 66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (113, 800.0, '', '2021-07-11 15:10:25-07', '2021-07-11 15:20:25-07', false, 66, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (114, 900.0, '', '2021-06-11 14:10:25-07', '2021-06-11 14:20:25-07', false, 66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (115, 2000.0, '', '2021-06-11 15:10:25-07', '2021-06-11 15:20:25-07', false, 66, null, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id,is_canceled)
	VALUES (116, 3000.0, '', '2021-06-17 18:00:25-07', '2021-06-17 18:10:25-07', false, 66, null, 111,false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id,is_canceled)
	VALUES (1161, 2000.0, '', '2021-06-17 16:00:25-07', '2021-06-17 16:10:25-07', false, 66, 88, 111,false);

INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (1179, 900.0, 'Headache and nausea', '2016-07-22 14:45:25-07', '2016-07-22 14:25:25-07', true, 66, 88, 111, false);
	
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (2179, 900.0, 'Headache and nausea', '2016-06-07 14:45:25-07', '2016-06-07 14:25:25-07', true, 66, 88, 111, false);
/*
	VALUES (111, 500.0, '', '2021-02-09 19:10:25-07', '2021-02-09 19:20:25-07', false, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (112, 1000.0, 'Headache and nausea', '2021-02-10 16:30:25-07', '2021-02-09 16:40:25-07', true, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (113, 800.0, 'Headache and nausea', '2021-02-11 15:10:25-07', '2021-02-11 15:20:25-07', true, 61, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (114, 900.0, 'Headache and nausea', '2021-02-11 14:10:25-07', '2021-02-11 14:20:25-07', true, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (115, 2000.0, '', '2021-02-13 15:10:25-07', '2021-02-13 15:20:25-07', true, 61, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id,is_canceled)
	VALUES (116, 3000.0, 'izvjestaj 2', '2021-08-13 18:00:25-07', '2021-08-13 18:10:25-07', false, 61, 88, 111,false);
    
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (117, 900.0, 'Headache and nausea', '2016-05-22 14:45:25-07', '2016-05-22 14:25:25-07', true, 61, 89, 111, false);
  */

	
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (118, 500.0, '', '2021-02-15 19:10:25-07', '2021-02-15 19:20:25-07', false, 66, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (119, 1000.0, 'Headache and nausea', '2021-02-15 16:30:25-07', '2021-02-15 16:40:25-07', true,66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (120, 800.0, '', '2021-02-23 09:10:25-07', '2021-02-23 09:20:25-07', false, 66, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (121, 900.0, '', '2021-02-23 10:10:25-07', '2021-02-23 10:20:25-07', false, 66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (122, 2000.0, '', '2021-02-12 15:10:25-07', '2021-02-12 15:20:25-07', true, 66, null, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (123, 3000.0, '', '2021-02-17 08:00:25-07', '2021-02-17 10:10:25-07', false, 66, 88, 222);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (124, 3000.0, '', '2021-02-17 11:00:25-07', '2021-02-17 11:10:25-07', false, 66, null, 222);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (125, 3000.0, '', '2021-02-17 12:00:25-07', '2021-02-17 12:10:25-07', false, 66, null, 222);

/*
	VALUES (118, 500.0, '', '2021-02-15 19:10:25-07', '2021-02-15 19:20:25-07', false, 61, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (119, 1000.0, 'Headache and nausea', '2021-02-15 16:30:25-07', '2021-02-15 16:40:25-07', true, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (120, 800.0, '', '2021-02-23 09:10:25-07', '2021-02-23 09:20:25-07', false, 61, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (121, 900.0, '', '2021-02-23 10:10:25-07', '2021-02-23 10:20:25-07', false, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (122, 2000.0, '', '2021-02-12 15:10:25-07', '2021-02-12 15:20:25-07', true, 61, null, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (123, 3000.0, '', '2021-02-17 08:00:25-07', '2021-02-17 10:10:25-07', false, 61, 88, 222);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (124, 3000.0, '', '2021-02-17 11:00:25-07', '2021-02-17 11:10:25-07', false, 61, null, 222);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (125, 3000.0, '', '2021-02-17 12:00:25-07', '2021-02-17 12:10:25-07', false, 61, null, 222);
  */
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
	id, end_time, start_time, text, medicine_id, pharmacy_id)
	VALUES (222,'2008-11-11 13:23:44','2008-11-11 13:23:44' ,'akcija 50%', 222,  111);
INSERT INTO public.action_or_promotion(
	id, end_time, start_time, text, medicine_id, pharmacy_id)
	VALUES (223,'2008-11-11 13:23:44','2008-11-11 13:23:44', 'akcija 30%', 223, 111);


INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (11, 250.0, 3, 222);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (21, 200.0, 3, 223);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (31, 200.0, 5, 223);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (41, 200.0, 5, 222);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (51,200.0, 4, 224);

-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 0);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 2);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 4);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 1);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 5);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 4);



INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (111, 5, 222, 100);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (211, 10, 223, 111);
	INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (411, 5, 5, 100);
	INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (611, 350.00, 7, 5);
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
/*INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (11, 385.00,3 , 8);*/

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
/*INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (21, 440.00,4, 13);
	*/


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
	VALUES (100, '2021-03-22', false, 11, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (101, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (102, '2021-06-12', false, 21, 89, 222, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (103, '2020-07-22', false, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (104, '2021-08-22', false, 21, 88, 111, false);
    

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
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (111, true, '2021-06-05', '2021-06-04','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (112, true, '2021-06-18','2021-06-18','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (113, true, '2021-06-09', '2021-06-09','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (114, true, '2021-06-14', '2021-06-12','111');


INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (66, 111);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (66, 112);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (77, 113);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (66, 114);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (66, 113);


INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (444, 112);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (444, 114);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (444, 113);
/*
	VALUES (61, 111);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (61, 112);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (71, 113);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (61, 114);

INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (41, 111);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (51, 112);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (51, 114);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (41, 113);
  */

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (111, '2021-06-6 20:00:00-07','2021-06-06 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (112, '2021-06-07 20:00:00-07','2021-06-07 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (113, '2021-06-08 20:00:00-07','2021-06-08 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (114, '2021-06-10 20:00:00-07','2021-06-10 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1131, '2021-06-11 20:00:00-07','2021-06-11 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1134, '2021-06-15 20:00:00-07','2021-06-15 12:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1133, '2021-06-16 20:00:00-07','2021-06-16 12:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1132, '2021-06-17 20:00:00-07','2021-06-17 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (11376, '2021-06-19 20:00:00-07','2021-06-19 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (11343, '2021-06-20 20:00:00-07','2021-06-20 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (11333, '2021-06-21 20:00:00-07','2021-06-21 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (115, '2021-07-12 20:00:00-07','2021-07-12 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (116, '2021-07-13 20:00:00-07','2021-07-13 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (117, '2021-07-14 20:00:00-07','2021-07-14 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1171, '2021-07-15 20:00:00-07','2021-07-15 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (118, '2021-07-16 20:00:00-07','2021-07-16 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (119, '2021-07-17 20:00:00-07','2021-07-17 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (120, '2021-07-23 20:00:00-07','2021-07-23 14:00:00-07','111');

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (211, '2021-07-09 15:00:00-07','2021-07-09 07:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (212, '2021-07-10 14:00:00-07','2021-07-10 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (213, '2021-07-11 15:00:00-07','2021-07-11 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (214, '2021-07-12 14:00:00-07','2021-07-12 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (215, '2021-07-13 15:00:00-07','2021-07-13 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (216, '2021-07-14 14:00:00-07','2021-07-14 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (217, '2021-07-15 14:00:00-07','2021-07-15 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (218, '2021-07-16 15:00:00-07','2021-07-16 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (219, '2021-07-17 14:00:00-07','2021-07-17 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (220, '2021-07-23 15:00:00-07','2021-07-23 08:00:00-07','222');

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 111);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 112);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 213);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 115);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 116);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 117);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 219);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 220);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 1131);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 1134);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 1133);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 1132);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 11376);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 11343);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 11333);

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (77, 112);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (444, 112);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (555, 111);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (555, 114);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (555, 115);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (444, 115);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (555, 116);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (555, 117);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (555, 118);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (555, 119);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (555, 120);


INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (444, 1131);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (444, 1134);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (444, 1133);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (444, 1132);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (444, 11376);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (444, 11343);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (444, 11333);
/*
	VALUES (61, 111);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 112);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 213);
	INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 115);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 116);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 117);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 219);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 220);

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (71, 112);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (41, 112);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 111);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 114);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 115);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (41, 115);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 116);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 117);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 118);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 119);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 120);
  */
  
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
	VALUES (111,'2016-10-09',2,11,0,111);
INSERT INTO public.eprescription(
	code, issuing_date,therapy_duration, medicine_id,status,pharmacy_id)
	VALUES (112,'2017-06-22',2,21,1,111);

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


/*
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 11);
	*/
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 31);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 21);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 41);

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
	VALUES (333, 26);/*
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 6);*/
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 12);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (333, 13);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (444, 14);/*
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (555, 21);*/
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

INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (777, 5, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (778, 3, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (779, 2, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (780, 5, 88);

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
	VALUES (555, 501);



	
INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id,is_processed)
	VALUES (211,'2021-11-11 13:23:44', 999,false);

INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id,is_processed)
	VALUES (311,'2022-11-11 13:23:44', 888,false);


INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (211, 111);
INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (211, 211);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (311, 3, 223, 100);
INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (311, 311);


	INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (557, 'neki datum', 14000.00, 2, 311, 100);
	
	INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (556, 'neki datum', 15000.00, 1, 211, 100);
	

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

INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks_id)
	VALUES (111, 777);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks_id)
	VALUES (111, 778);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks_id)
	VALUES (111, 779);
INSERT INTO public.pharmacy_marks(
	pharmacy_id, marks_id)
	VALUES (111, 780);


INSERT INTO public.loyalty_programme(
	id, gold, gold_discount, points_for_counceling, points_for_examination, regular, regular_discount, silver, silver_discount)
	VALUES (1, 200, 0.5, 10, 10, 50, 0.2, 100, 0.3);


INSERT INTO public.action_or_promotion(
	id, text, medicine_id, pharmacy_id,start_time,end_time)
	VALUES (331, 'akcija 350%', 222,  111,'2019-08-13 17:00:00-07', '2024-08-13 17:25:25-07');
INSERT INTO public.action_or_promotion(
	id, text, medicine_id, pharmacy_id,start_time,end_time)
	VALUES (443, 'akcija 530%', 223, 111,'2019-08-13 17:00:00-07', '2024-08-13 17:25:25-07');
	VALUES (334,223, '2021-05-13 16:00:00-07',111,false);


INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (345, 'neki datum', 14000.00, 2, 311, 100);
	
INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (432, 'neki datum', 15000.00, 2, 211, 100);
	

INSERT INTO AUTHORITY (name) VALUES ('ROLE_PATIENT');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PHARMACYADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PHARMACIST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_DERMATOLOGIST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_SUPPLIER');


INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (88, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (89, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (90, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (69, 1);

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (66, 5);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (77, 5);

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (122,2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (133,2);

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (555, 4);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (444, 4);

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (999, 3);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (888, 3);

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (100, 6);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (111, 6);


INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (912, false, '2021-09-12', '2021-08-12','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (913, false, '2021-11-22','2021-10-18','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (914, false, '2021-11-22', '2021-10-19','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (915, false, '2021-09-29', '2021-08-19','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (916, false, '2021-09-12', '2021-08-12','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (917, false, '2021-11-22','2021-10-18','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (918, false, '2021-11-22', '2021-10-19','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (919, false, '2021-09-29', '2021-08-19','111');

INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (66, 912);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (66, 913);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (77, 914);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (66, 915);


INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (555, 916);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (555, 917);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (444, 918);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (444, 919);

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (187, '2021-08-08 20:00:00-07','2021-8-08 11:00:00-07','111');


INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 187);

INSERT INTO public.medicine_request(
	id, date,solved,medicine_id,pharmacy_id)
	VALUES (123,'2021-08-08 20:00:00-07', false,222,111);
INSERT INTO public.medicine_request(
	id, date,solved,medicine_id,pharmacy_id)
	VALUES (124,'2021-08-08 20:00:00-07', false,223,111);
INSERT INTO public.medicine_request(
	id, date,solved,medicine_id,pharmacy_id)
	VALUES (125,'2021-08-08 20:00:00-07', false,224,111);
INSERT INTO public.medicine_request(
	id, date,solved,medicine_id,pharmacy_id)
	VALUES (126,'2021-08-08 20:00:00-07', false,222,111);
INSERT INTO public.medicine_request(
	id, date,solved,medicine_id,pharmacy_id)
	VALUES (127,'2021-08-08 20:00:00-07', false,223,111);

INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (333, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (334, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (335, '2021-06-12', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (336, '2021-07-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (337, '2021-08-22', true, 21, 88, 111, false);

INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (338, '2021-03-19', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (339, '2021-03-30', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (340, '2021-03-12', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (341, '2021-03-31', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (342, '2021-03-04', true, 21, 88, 111, false);
	INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (343, '2021-03-11', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (344, '2021-03-02', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (345, '2021-03-01', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (346, '2021-03-06', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (347, '2021-03-07', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (348, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (349, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (350, '2021-03-12', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (351, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (352, '2021-03-22', true, 21, 88, 111, false);
	INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (353, '2021-03-11', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (354, '2021-03-02', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (355, '2021-03-09', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (356, '2021-03-17', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (357, '2021-03-07', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (358, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (359, '2021-03-31', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (360, '2021-03-12', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (361, '2020-03-31', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (362, '2021-03-22', true, 21, 88, 111, false);
	INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (363, '2021-03-11', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (364, '2021-03-02', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (365, '2021-03-01', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (366, '2021-03-23', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (367, '2021-03-23', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (368, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (369, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (370, '2021-03-12', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (371, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (372, '2021-03-23', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (373, '2021-03-11', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (374, '2021-03-02', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (375, '2021-03-09', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (376, '2021-03-17', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (377, '2021-03-07', true, 21, 88, 111, false);

INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (555, 500.0, 'Headache and nausea', '2021-03-06 19:10:25-07', '2021-03-06 19:20:25-07', true, 66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (556, 1000.0, '', '2021-03-09 16:30:25-07', '2021-03-09 16:40:25-07', true, 66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (557, 800.0, '', '2021-03-11 15:10:25-07', '2021-03-11 15:20:25-07', true, 66, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (558, 900.0, '', '2021-03-11 14:10:25-07', '2021-03-11 14:20:25-07', true, 66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (559, 2000.0, '', '2021-03-11 15:10:25-07', '2021-03-11 15:20:25-07', true, 66, null, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id,is_canceled)
	VALUES (560, 3000.0, '', '2021-03-17 18:00:25-07', '2021-03-17 18:10:25-07', true, 66, null, 111,false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id,is_canceled)
	VALUES (561, 2000.0, '', '2021-03-17 16:00:25-07', '2021-03-17 16:10:25-07', true, 66, null, 111,false);

INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (562, 500.0, 'Headache and nausea', '2021-09-06 19:10:25-07', '2021-09-06 19:20:25-07', true, 66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (563, 1000.0, '', '2021-08-09 16:30:25-07', '2021-08-09 16:40:25-07', true, 66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (564, 800.0, '', '2021-08-11 15:10:25-07', '2021-08-11 15:20:25-07', true, 66, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (565, 900.0, '', '2021-02-11 14:10:25-07', '2021-02-11 14:20:25-07', true, 66, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (566, 2000.0, '', '2021-05-11 15:10:25-07', '2021-05-11 15:20:25-07', true, 66, null, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id,is_canceled)
	VALUES (567, 3000.0, '', '2021-04-17 18:00:25-07', '2021-04-17 18:10:25-07', true, 66, null, 111,false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id,is_canceled)
	VALUES (568, 2000.0, '', '2021-05-17 16:00:25-07', '2021-05-17 16:10:25-07', true, 66, null, 111,false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id,is_canceled)
	VALUES (577, 1000.0, '', '2021-03-22 16:00:25-07', '2021-03-22 16:10:25-07', true, 66, null, 111,false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (577, '2021-03-22', true, 21, 88, 111, false);

INSERT INTO public.map_location(
	id,x,y,pharmacy_id)
	VALUES (55,19.801890,45.241850,111);
INSERT INTO public.map_location(
	id,x,y,pharmacy_id)
	VALUES (56,19.837560,45.246180,222);

INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (501, 1000.0, '', '2022-07-11 15:00:00-07', '2022-07-11 15:25:25-07', false, null, 555, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (502, 2000.0, '', '2021-07-16 17:00:00-07', '2022-07-16 17:25:25-07', false, null, 555, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (503, 1000.0, '', '2022-07-15 16:00:00-07', '2022-07-15 16:25:25-07', false, null, 555, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (504, 2000.0, '', '2021-07-18 17:00:00-07', '2022-07-18 17:25:25-07', false, null, 555, 111, false);

INSERT INTO public.eprescription(
	code, issuing_date,therapy_duration, medicine_id,status,pharmacy_id)
	VALUES (501,'2020-10-09',2,11,0,111);
INSERT INTO public.eprescription(
	code, issuing_date,therapy_duration, medicine_id,status,pharmacy_id)
	VALUES (502,'2020-06-22',2,21,0,111);

INSERT INTO public.patient_eprescriptions(
	patient_id, eprescriptions_code)
	VALUES (89, 501);
INSERT INTO public.patient_eprescriptions(
	patient_id, eprescriptions_code)
	VALUES (89, 502);


INSERT INTO public.eprescription(
	code, issuing_date,therapy_duration, medicine_id,status,pharmacy_id)
	VALUES (503,'2020-09-01',2,31,0,111);
INSERT INTO public.eprescription(
	code, issuing_date,therapy_duration, medicine_id,status,pharmacy_id)
	VALUES (504,'2020-06-25',2,51,0,111);

INSERT INTO public.patient_eprescriptions(
	patient_id, eprescriptions_code)
	VALUES (89, 503);
INSERT INTO public.patient_eprescriptions(
	patient_id, eprescriptions_code)
	VALUES (89, 504);

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (501, '2021-07-06 20:00:00-07','2021-07-06 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (502, '2021-07-07 20:00:00-07','2021-07-07 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (503, '2021-07-08 20:00:00-07','2021-07-08 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (504, '2021-07-10 20:00:00-07','2021-07-10 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (505, '2021-07-12 20:00:00-07','2021-07-12 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (506, '2021-07-13 20:00:00-07','2021-07-13 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (507, '2021-07-15 20:00:00-07','2021-07-15 12:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
VALUES (508, '2021-07-16 20:00:00-07','2021-07-16 12:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
VALUES (509, '2021-07-17 20:00:00-07','2021-07-17 12:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
VALUES (510, '2021-07-18 20:00:00-07','2021-07-18 12:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
VALUES (511, '2021-07-19 20:00:00-07','2021-07-19 12:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
VALUES (512, '2021-07-20 20:00:00-07','2021-07-20 12:00:00-07','111');

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 501);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 502);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 503);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 504);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 505);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 506);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 507);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 508);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 509);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 510);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 511);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (66, 512);


INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (501, false, '2021-06-15', '2021-06-15','111');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start,pharmacy_id)
	VALUES (502, true, '2021-06-16','2021-06-16','111');

INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (66, 501);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (66, 502);

INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id,is_processed)
	VALUES (501,'2020-11-11 13:23:44', 888,false);
	
INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id,is_processed)
	VALUES (502,'2020-11-11 13:23:44', 999,false);

INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id,is_processed)
	VALUES (503,'2020-11-11 13:23:44', 333,false);


INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (501, 5, 222, 100);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (502, 10, 223, 111);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (503, 5, 5, 100);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (504, 5, 223, 111);


INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (501, 501);
INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (502, 502);
INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (503, 503);
INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (503, 504);



INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
VALUES (501, '2022-11-11 13:23:44', 14000.00, 2, 501, 100);
	
INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
VALUES (502, '2022-12-11 13:23:44', 15000.00, 2, 502, 100);
	
	
INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
VALUES (503, '2022-11-11 13:23:44', 14000.00, 2, 503, 100);
	
INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
VALUES (504, '2022-12-06 13:23:44', 1200.00, 2, 503, 100);

INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (855, 'neki datum', 16000.00, 2, 501, 111);
  
INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
VALUES (555, 'neki datum', 16000.00, 2, 503, 100);


INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (501, '2020-07-22', false, 31, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (502, '2021-08-22', false, 31, 88, 111, false);

INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
VALUES (601, '2021-06-12', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (602, '2021-06-12', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (503, '2021-06-10', true, 18, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (504, '2021-06-18', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (505, '2021-06-11', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (506, '2021-06-22', true, 18, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (507, '2021-06-23', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (508, '2021-06-21', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (509, '2021-05-12', true, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (510, '2021-05-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (511, '2021-06-23', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (512, '2021-05-11', true, 18, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (513, '2021-04-02', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (514, '2021-04-09', true, 18, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (515, '2021-06-17', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (516, '2021-04-01', true, 18, 88, 111, false);

INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (666, 1000.0, '', '2021-04-11 15:00:00-07', '2021-04-11 15:25:25-07', true, null, 555, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (667, 2000.0, '', '2021-03-16 17:00:00-07', '2021-03-16 17:25:25-07', true, null, 555, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (668, 1000.0, '', '2021-03-15 16:00:00-07', '2021-03-15 16:25:25-07', true, null, 555, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (669, 2000.0, '', '2021-04-18 17:00:00-07', '2021-04-18 17:25:25-07', true, null, 555, 111, false);

INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (51, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', true, true, 'Stevan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632213455', 'Katic',true,'2008-11-11 13:23:44','stevan.katic');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (51, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Stevan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632213455', 'Katic',true,'2008-11-11 13:23:44','stevan.katic');
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (52, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Milan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632413455', 'Radic',true,'2008-11-11 13:23:44','radeM');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (52, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Milan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632413455', 'Radic',true,'2008-11-11 13:23:44','radeM');


INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (61, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', true, true, 'Dusan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632213455', 'Peric',true,'2008-11-11 13:23:44','dusanper');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (61, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Dusan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632213455', 'Peric',true,'2008-11-11 13:23:44','dusanper');
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (62, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Janko', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632413455', 'Milosevic',true,'2008-11-11 13:23:44','milos');
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (62, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Janko', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0632413455', 'Milosevic',true,'2008-11-11 13:23:44','milos');

INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (61, 111);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (61, 444);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (62, 111);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (51, 111);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (52, 111);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (62, 222);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (51, 222);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (62, 333);

INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, pharmacy_id)
	VALUES (891, 'Ticanova 1', 'Ruma', 'Srbija', 'neki opis', 'ta.drcelic@gmail.com', true, true, 'Vesna', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0654431123', 'Starcevic',true,'2008-11-11 13:23:44','vstarcevic', 111);    
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (891, 'Ticanova 1', 'Ruma', 'Srbija', 'neki opis', 'ta.drcelic@gmail.com', false, false, 'Vesna', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0654431123', 'Starcevic',true,'2008-11-11 13:23:44','vstarcevic');    
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username, pharmacy_id)
	VALUES (65, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Milena', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06541111123', 'Milic',true,'2008-11-11 13:23:44','mimi',111);
INSERT INTO public.users(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, enabled, last_password_reset_date, username)
	VALUES (65, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', 'neki opis', 'aleksarep0408@gmail.com', false, false, 'Milena', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '06541111123', 'Milic',true,'2008-11-11 13:23:44','mimi');

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1000, '2021-06-6 20:00:00-07','2021-06-06 11:00:00-07','111');
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
VALUES (61, 1000);
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1001, '2021-06-07 20:00:00-07','2021-06-07 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1002, '2021-06-08 20:00:00-07','2021-06-08 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1003, '2021-06-10 20:00:00-07','2021-06-10 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1004, '2021-06-11 20:00:00-07','2021-06-11 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1005, '2021-06-15 20:00:00-07','2021-06-15 12:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1006, '2021-06-16 20:00:00-07','2021-06-16 12:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1007, '2021-06-17 20:00:00-07','2021-06-17 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1008, '2021-06-19 20:00:00-07','2021-06-19 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1009, '2021-06-20 20:00:00-07','2021-06-20 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1010, '2021-06-21 20:00:00-07','2021-06-21 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1011, '2021-07-12 20:00:00-07','2021-07-12 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1012, '2021-07-13 20:00:00-07','2021-07-13 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (1013, '2021-07-14 20:00:00-07','2021-07-14 11:00:00-07','111');



INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1001);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1002);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1003);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1004);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1005);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1006);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1007);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1008);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1009);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1010);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1011);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1012);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 1013);

INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (6969, 500.0, 'Headache and nausea', '2021-06-06 19:10:25-07', '2021-06-06 19:20:25-07',false, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (6970, 1000.0, '', '2021-07-10 16:30:25-07', '2021-07-10 16:40:25-07', false, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (6980, 800.0, '', '2021-07-11 15:10:25-07', '2021-07-11 15:20:25-07',false, 61, 89, 111, false);

INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (600, 4, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (601, 1, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (602, 4, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (603, 3, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (604, 5, 89);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (605, 5, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (606, 3, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (607, 2, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (608, 5, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (609, 4, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (610, 5, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (611, 1, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (612, 2, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (613, 3, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (614, 5, 89);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (615, 5, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (616, 3, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (617, 2, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (618, 5, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (619, 4, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (620, 4, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (621, 2, 88);
	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (622, 5, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (623, 3, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (624, 5, 89);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (625, 5, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (626, 3, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (627, 2, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
VALUES (628, 5, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (629, 4, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (630, 3, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (631, 2, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (632, 3, 88);



INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (891, 601);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (891, 602);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (891, 603);	
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (891, 604);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (891, 605);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (891, 606);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (891, 607);	
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (891, 608);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (555, 609);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (555, 610);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (555, 611);	
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (555, 612);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (555, 613);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (555, 614);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (555, 615);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (65, 616);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (65, 617);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (65, 618);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (65, 619);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (65, 620);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (66, 621);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (66, 622);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (66, 623);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (51, 624);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (51, 625);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (51, 626);
INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (52, 627);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (52, 628);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (52, 629);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (61, 630);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (61, 631);
 INSERT INTO public.dermatologist_marks(dermatologist_id, marks_id) VALUES (61, 632);

INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (667, 295.0, 16, 5);

INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 667);

INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (777, 1000.0, '', '2022-06-17 16:00:00-07', '2021-06-17 16:25:25-07', false, null, 65, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (778, 2000.0, '', '2021-10-11 17:00:00-07', '2021-10-11 17:25:25-07', false, null, 65, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (789, 1000.0, '', '2022-06-11 15:00:00-07', '2021-06-11 15:25:25-07', false, null, 65, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (790, 1000.0, '', '2022-09-17 16:00:00-07', '2021-09-17 16:25:25-07', false, null, 65, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (791, 2000.0, '', '2021-08-11 17:00:00-07', '2021-08-11 17:25:25-07', false, null, 555, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (792, 1000.0, '', '2022-07-11 15:00:00-07', '2021-07-11 15:25:25-07', false, null, 555, 111, false);