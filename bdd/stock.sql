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
-- Name: stock; Type: TABLE; Schema: public; Owner: Supervisor
--

CREATE TABLE stock (
    refstore character varying(255) NOT NULL,
    refproduct character varying(255) NOT NULL,
    status character varying(255),
    creationdate timestamp with time zone NOT NULL,
    lastupdate timestamp with time zone,
    quantity bigint NOT NULL,
    vat bigint NOT NULL,
    priceht bigint NOT NULL
  
);


--ALTER TABLE stock OWNER TO "Supervisor";

--
-- Name: stock stock_pkey; Type: CONSTRAINT; Schema: public; Owner: Supervisor
--

ALTER TABLE ONLY stock
    ADD CONSTRAINT stock_pkey PRIMARY KEY (refstore, refproduct);


--
-- Name: stock _fluent_foreignkey_d5e44b; Type: FK CONSTRAINT; Schema: public; Owner: Supervisor
--

ALTER TABLE ONLY stock
    ADD CONSTRAINT _fluent_foreignkey_d5e44b FOREIGN KEY (refproduct) REFERENCES products(refproduct);


--
-- Name: stock _fluent_foreignkey_edb1a7; Type: FK CONSTRAINT; Schema: public; Owner: Supervisor
--

ALTER TABLE ONLY stock
    ADD CONSTRAINT _fluent_foreignkey_edb1a7 FOREIGN KEY (refstore) REFERENCES stores(refstore);


--
-- PostgreSQL database dump complete
--
