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
    