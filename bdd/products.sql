--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: products; Type: TABLE; Schema: public; Owner: Supervisor
--

CREATE TABLE products (
    refproduct character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    picture character varying(255),
    creationdate timestamp with time zone NOT NULL
);


--ALTER TABLE products OWNER TO "Supervisor";

--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: Supervisor
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (refproduct);


--
-- PostgreSQL database dump complete
--
