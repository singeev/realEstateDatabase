CREATE TABLE public.user (
  id           SERIAL           NOT NULL PRIMARY KEY,
  first_name   VARCHAR(150)     NOT NULL,
  second_name  VARCHAR(150)     NOT NULL,
  last_name    VARCHAR(150)     NOT NULL,
  email        VARCHAR(150)     NOT NULL,
  phone        VARCHAR(150)     NOT NULL,
  password     VARCHAR(150)     NOT NULL
);
CREATE INDEX index_user_id ON public.user (id);
CREATE INDEX index_user_email ON public.user (email);

CREATE TABLE public.role (
  id   SERIAL       NOT NULL PRIMARY KEY,
  name VARCHAR(50)  NOT NULL UNIQUE
);

CREATE TABLE public.users_roles (
  user_id SERIAL       NOT NULL REFERENCES public.user (id),
  role_id SERIAL       NOT NULL REFERENCES public.role (id)
);