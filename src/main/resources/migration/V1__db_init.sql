CREATE TABLE public.users (
  id           SERIAL           NOT NULL PRIMARY KEY,
  first_name   VARCHAR(150)     NOT NULL,
  second_name  VARCHAR(150)     NOT NULL,
  last_name    VARCHAR(150)     NOT NULL,
  email        VARCHAR(150)     NOT NULL,
  phone        VARCHAR(150)     NOT NULL,
  password     VARCHAR(150)     NOT NULL
);
CREATE INDEX index_users_id ON public.users (id);
CREATE INDEX index_users_email ON public.users (email);