-- tm_account 
CREATE TABLE tm_account
(
  account_id character(32) NOT NULL,
  name character varying(100) NOT NULL,
  email text NOT NULL,
  password text NOT NULL,
  delete_flag boolean NOT NULL DEFAULT false,
  CONSTRAINT pk_kakeibo PRIMARY KEY (account_id),
  CONSTRAINT uni_account_01 UNIQUE (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tm_account OWNER TO ${owner};

-- tm_group
CREATE TABLE tm_group
(
  group_id character(32) NOT NULL,
  name character varying(100) NOT NULL
  delete_flag boolean NOT NULL DEFAULT false,
  CONSTRAINT pk_group PRIMARY KEY (group_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tm_group OWNER TO ${owner};

-- tr_group_account
CREATE TABLE tr_group_account
(
  group_id character(32) NOT NULL,
  account_id character(32) NOT NULL,
  CONSTRAINT pk_group_account PRIMARY KEY (group_id, account_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tr_group_account OWNER TO ${owner};

-- td_kakeibo
CREATE TABLE td_kakeibo
(
  kakeibo_id character(32) NOT NULL,
  title character varying(100) NOT NULL,
  memo text,
  group_id character(32) NOT NULL,
  account_id character(32) NOT NULL,
  delete_flag boolean NOT NULL DEFAULT false,
  CONSTRAINT pk_kakeibo PRIMARY KEY (kakeibo_id),
  CONSTRAINT uni_kakeibo_01 UNIQUE (year, month)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE td_kakeibo OWNER TO ${owner};

-- td_receipt
CREATE TABLE td_receipt
(
  receipt_id character(32) NOT NULL,
  kakeibo_id character(32) NOT NULL,
  date timestamp without time zone,
  shop_name character varying(500),
  shop_name_sub character varying(500),
  shop_tel character varying(500),
  shop_address character varying(500),
  shop_id character(32),
  memo character varying(1000),
  delete_flag boolean NOT NULL DEFAULT false,
  CONSTRAINT pk_receipt PRIMARY KEY (receipt_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE td_receipt OWNER TO ${owner};

-- td_receipt_item
CREATE TABLE td_receipt_item
(
  receipt_id character(32) NOT NULL,
  no integer NOT NULL,
  name character varying(500),
  price integer,
  quantity integer,
  item_id character(32),
  memo character varying(1000),
  delete_flag boolean NOT NULL DEFAULT false,
  CONSTRAINT pk_receipt_item PRIMARY KEY (receipt_id, no)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE td_receipt_item OWNER TO ${owner};