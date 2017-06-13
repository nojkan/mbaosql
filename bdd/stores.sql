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
-- Name: stores; Type: TABLE; Schema: public; Owner: Supervisor
--

CREATE TABLE stores (
    refstore character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    picture character varying(255),
    vat bigint,
    currency character varying(255),
    merchantkey character varying(255)
);


--ALTER TABLE stores OWNER TO "Supervisor";

--
-- Name: stores stores_pkey; Type: CONSTRAINT; Schema: public; Owner: Supervisor
--

ALTER TABLE ONLY stores
    ADD CONSTRAINT stores_pkey PRIMARY KEY (refstore);


--
-- PostgreSQL database dump complete
--
