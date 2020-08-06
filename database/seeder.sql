use jpa_examples_db;

insert into ad_details (extra_info) values ('more info about Solarbreeze');
insert into ad_details (extra_info) values ('more info about Biodex');
insert into ad_details (extra_info) values ('more info about Stringtough');
insert into ad_details (extra_info) values ('more info about Bytecard');
insert into ad_details (extra_info) values ('more info about Stim');
insert into ad_details (extra_info) values ('more info about Rank');
insert into ad_details (extra_info) values ('more info about Vagram');
insert into ad_details (extra_info) values ('more info about Y-find');
insert into ad_details (extra_info) values ('more info about It');
insert into ad_details (extra_info) values ('more info about Tresom');

insert into ads (title, description, ad_details_id) values ('Solarbreeze', 'quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc', 1);
insert into ads (title, description, ad_details_id) values ('Biodex', 'nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non', 2);
insert into ads (title, description, ad_details_id) values ('Stringtough', 'pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus', 3);
insert into ads (title, description, ad_details_id) values ('Bytecard', 'mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum', 4);
insert into ads (title, description, ad_details_id) values ('Stim', 'donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in', 5);
insert into ads (title, description, ad_details_id) values ('Rank', 'massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate', 6);
insert into ads (title, description, ad_details_id) values ('Vagram', 'sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor', 7);
insert into ads (title, description, ad_details_id) values ('Y-find', 'ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor', 8);
insert into ads (title, description, ad_details_id) values ('It', 'eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices', 9);
insert into ads (title, description, ad_details_id) values ('Tresom', 'ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis', 10);

insert into comments (content, ad_id) values ('Solarbreeze', 1);
insert into comments (content, ad_id) values ('Biodex', 1);
insert into comments (content, ad_id) values ('Stringtough', 1);
insert into comments (content, ad_id) values ('Bytecard', 1);
insert into comments (content, ad_id) values ('Stim', 2);
insert into comments (content, ad_id) values ('Rank', 3);
insert into comments (content, ad_id) values ('Vagram', 3);
insert into comments (content, ad_id) values ('Test', 3);
insert into comments (content, ad_id) values ('It', 3);
insert into comments (content, ad_id) values ('Tresom', 3);

insert into tags (name) values ('tag a');
insert into tags (name) values ('tag b');
insert into tags (name) values ('tag c');
insert into tags (name) values ('tag d');
insert into tags (name) values ('tag e');
insert into tags (name) values ('tag f');
insert into tags (name) values ('tag g');
insert into tags (name) values ('tag h');
insert into tags (name) values ('tag i');
insert into tags (name) values ('tag j');

insert into ad_tag (ad_id, tag_id) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 1),
  (3, 1),
  (4, 1);



