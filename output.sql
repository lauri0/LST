--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: candidate; Type: TABLE; Schema: public; Owner: rkedzlcjnodrbm; Tablespace: 
--

CREATE TABLE candidate (
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    party character varying(50) NOT NULL,
    party_webpage character varying
);


ALTER TABLE public.candidate OWNER TO rkedzlcjnodrbm;

--
-- Name: candidate_id_seq; Type: SEQUENCE; Schema: public; Owner: rkedzlcjnodrbm
--

CREATE SEQUENCE candidate_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.candidate_id_seq OWNER TO rkedzlcjnodrbm;

--
-- Name: candidate_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rkedzlcjnodrbm
--

ALTER SEQUENCE candidate_id_seq OWNED BY candidate.id;


--
-- Name: comment; Type: TABLE; Schema: public; Owner: rkedzlcjnodrbm; Tablespace: 
--

CREATE TABLE comment (
    id integer NOT NULL,
    message text
);


ALTER TABLE public.comment OWNER TO rkedzlcjnodrbm;

--
-- Name: comment_id_seq; Type: SEQUENCE; Schema: public; Owner: rkedzlcjnodrbm
--

CREATE SEQUENCE comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comment_id_seq OWNER TO rkedzlcjnodrbm;

--
-- Name: comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rkedzlcjnodrbm
--

ALTER SEQUENCE comment_id_seq OWNED BY comment.id;


--
-- Name: election; Type: TABLE; Schema: public; Owner: rkedzlcjnodrbm; Tablespace: 
--

CREATE TABLE election (
    id smallint NOT NULL,
    type character varying(50) NOT NULL,
    "time" character varying(50)
);


ALTER TABLE public.election OWNER TO rkedzlcjnodrbm;

--
-- Name: referee; Type: TABLE; Schema: public; Owner: rkedzlcjnodrbm; Tablespace: 
--

CREATE TABLE referee (
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    occupation character varying(50) NOT NULL,
    email character varying(50) NOT NULL
);


ALTER TABLE public.referee OWNER TO rkedzlcjnodrbm;

--
-- Name: referee_choices; Type: TABLE; Schema: public; Owner: rkedzlcjnodrbm; Tablespace: 
--

CREATE TABLE referee_choices (
    id integer NOT NULL,
    referee_id smallint NOT NULL,
    election_id smallint NOT NULL,
    comment_id smallint NOT NULL,
    candidate_id smallint NOT NULL
);


ALTER TABLE public.referee_choices OWNER TO rkedzlcjnodrbm;

--
-- Name: referee_choices_id_seq; Type: SEQUENCE; Schema: public; Owner: rkedzlcjnodrbm
--

CREATE SEQUENCE referee_choices_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.referee_choices_id_seq OWNER TO rkedzlcjnodrbm;

--
-- Name: referee_choices_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rkedzlcjnodrbm
--

ALTER SEQUENCE referee_choices_id_seq OWNED BY referee_choices.id;


--
-- Name: referee_id_seq; Type: SEQUENCE; Schema: public; Owner: rkedzlcjnodrbm
--

CREATE SEQUENCE referee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.referee_id_seq OWNER TO rkedzlcjnodrbm;

--
-- Name: referee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rkedzlcjnodrbm
--

ALTER SEQUENCE referee_id_seq OWNED BY referee.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: rkedzlcjnodrbm
--

ALTER TABLE ONLY candidate ALTER COLUMN id SET DEFAULT nextval('candidate_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: rkedzlcjnodrbm
--

ALTER TABLE ONLY comment ALTER COLUMN id SET DEFAULT nextval('comment_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: rkedzlcjnodrbm
--

ALTER TABLE ONLY referee ALTER COLUMN id SET DEFAULT nextval('referee_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: rkedzlcjnodrbm
--

ALTER TABLE ONLY referee_choices ALTER COLUMN id SET DEFAULT nextval('referee_choices_id_seq'::regclass);


--
-- Data for Name: candidate; Type: TABLE DATA; Schema: public; Owner: rkedzlcjnodrbm
--

COPY candidate (id, first_name, last_name, party, party_webpage) FROM stdin;
1	Otto	Triin	Reformierakond	reformierakond.ee
2	Olev	Ait	Reformierakond	reformierakond.ee
3	Taavi	Rõivas	Reformierakond	reformierakond.ee
4	Urve	Palo	Sotsiaaldemokraatlik erakond	www.sotsdem.ee
\.


--
-- Name: candidate_id_seq; Type: SEQUENCE SET; Schema: public; Owner: rkedzlcjnodrbm
--

SELECT pg_catalog.setval('candidate_id_seq', 4, true);


--
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: rkedzlcjnodrbm
--

COPY comment (id, message) FROM stdin;
1	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
13	Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem
2	Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.
14	 randoomne kommentaar! 
\.


--
-- Name: comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: rkedzlcjnodrbm
--

SELECT pg_catalog.setval('comment_id_seq', 14, true);


--
-- Data for Name: election; Type: TABLE DATA; Schema: public; Owner: rkedzlcjnodrbm
--

COPY election (id, type, "time") FROM stdin;
1	Riigikogu valimised	\N
\.


--
-- Data for Name: referee; Type: TABLE DATA; Schema: public; Owner: rkedzlcjnodrbm
--

COPY referee (id, first_name, last_name, occupation, email) FROM stdin;
1	Mari	Maasik	ajakirjanik	mari.maasik@gmail.com
3	Kaspar	Muttik	akadeemik	kaspar.muttik@gmail
2	Oskar	Mets	laulja	kaspar.muttik@gmail.com
5	Jaanus	Mesipuu	muidusööja	jansu81@hot.ee
6	Kadi	Minsk	sotsioloog	kadike87@gmail.com
10	Malle	Metssalu	averageJoe	malle.metsalu@gmail.com
11	Lauri	Kongas	tore amet	laurikongas00@gmail.com
12	Artur	Käpp	asd	arturkp@gmail.com
17	Tiina	Kask	korstnapÃ¼hkija	tiina.kask123@gmail.com
\.


--
-- Data for Name: referee_choices; Type: TABLE DATA; Schema: public; Owner: rkedzlcjnodrbm
--

COPY referee_choices (id, referee_id, election_id, comment_id, candidate_id) FROM stdin;
1	1	1	1	1
5	10	1	4	1
6	11	1	6	1
7	12	1	7	1
8	13	1	9	1
9	14	1	10	1
10	15	1	11	1
11	16	1	12	1
12	5	1	13	3
14	2	1	2	4
15	17	1	14	1
\.


--
-- Name: referee_choices_id_seq; Type: SEQUENCE SET; Schema: public; Owner: rkedzlcjnodrbm
--

SELECT pg_catalog.setval('referee_choices_id_seq', 15, true);


--
-- Name: referee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: rkedzlcjnodrbm
--

SELECT pg_catalog.setval('referee_id_seq', 17, true);


--
-- Name: referee_pkey; Type: CONSTRAINT; Schema: public; Owner: rkedzlcjnodrbm; Tablespace: 
--

ALTER TABLE ONLY referee
    ADD CONSTRAINT referee_pkey PRIMARY KEY (email);


--
-- Name: public; Type: ACL; Schema: -; Owner: rkedzlcjnodrbm
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM rkedzlcjnodrbm;
GRANT ALL ON SCHEMA public TO rkedzlcjnodrbm;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

