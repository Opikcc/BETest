-- Table: public.anggota

-- DROP TABLE IF EXISTS public.anggota;

CREATE TABLE IF NOT EXISTS public.anggota
(
    id bigint NOT NULL DEFAULT nextval('member_id_seq'::regclass),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    tgl_lahir character(8) COLLATE pg_catalog."default",
    alamat character varying(250) COLLATE pg_catalog."default",
    CONSTRAINT member_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.anggota
    OWNER to postgres;
		
-- Table: public.tx_acct

-- DROP TABLE IF EXISTS public.tx_acct;

CREATE TABLE IF NOT EXISTS public.tx_acct
(
    id bigint NOT NULL DEFAULT nextval('tx_acct_id_seq'::regclass),
    tgl_transaksi character(8) COLLATE pg_catalog."default",
    debit_acct bigint,
    kredit_acct bigint,
    type_acct character varying(20) COLLATE pg_catalog."default",
    nominal double precision,
    CONSTRAINT tx_acct_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tx_acct
    OWNER to postgres;