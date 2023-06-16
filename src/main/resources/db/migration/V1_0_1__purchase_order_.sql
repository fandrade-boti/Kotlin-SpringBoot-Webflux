CREATE TABLE purchase_order (
    id                      BIGSERIAL       NOT NULL,
    store_code              VARCHAR(30)     NOT NULL,
    status                  VARCHAR(200)    NOT NULL,
    status_internal         VARCHAR(200)    NOT NULL,
    business_unit           VARCHAR(30)     NOT NULL,

    shipping_type           VARCHAR(100)    ,
    erp                     VARCHAR(30)     ,


    error_code              VARCHAR(50)     ,
    error_message           TEXT            ,

    created_at              TIMESTAMP       NOT NULL,
    updated_at              TIMESTAMP       NOT NULL
);


CREATE TABLE purchase_order_item (
    id                              BIGSERIAL       NOT NULL,
    purchase_order_id               BIGINT          NOT NULL,
    sku_code                        VARCHAR(50)     NOT NULL,
    sku_brand                       VARCHAR(50)     NOT NULL,
    status                          VARCHAR(200)    NOT NULL,
    status_internal                 VARCHAR(200)    NOT NULL,
    original_quantity               INT             NOT NULL,
    request_quantity                INT             NOT NULL,
    pending_quantity                INT             ,
    delivered_quantity              INT             ,
    refused_quantity                INT             ,
    suggested_emitter_quantity      INT             ,

    error_code                      VARCHAR(50)     ,
    error_message                   TEXT            ,

    created_at                      TIMESTAMP       NOT NULL,
    updated_at                      TIMESTAMP       NOT NULL
);

CREATE TABLE fulfillment(
    id                         BIGSERIAL       NOT NULL,
    purchase_order_id          BIGINT          NOT NULL,
    status                     VARCHAR(200)    NOT NULL,
    status_internal            VARCHAR(200)    NOT NULL,
    sales_order_identifier     VARCHAR(100)    ,
    point_sale_identifier      VARCHAR(100)    ,
    shipping_type              VARCHAR(100)    ,

    error_code                 VARCHAR(50)     ,
    error_message              TEXT            ,

    created_at                 TIMESTAMP       NOT NULL,
    updated_at                 TIMESTAMP       NOT NULL
);

CREATE TABLE fulfillment_item(
    id                              BIGSERIAL       NOT NULL,
    guid                            VARCHAR(200)    NOT NULL,

    fulfillment_id                  BIGINT          NOT NULL,
    purchase_order_item_id          BIGINT          NOT NULL,
    origin_fulfillment_item_id      BIGINT          ,
    destiny_fulfillment_item_id     BIGINT          ,

    status                          VARCHAR(200)    NOT NULL,
    status_internal                 VARCHAR(200)    NOT NULL,

    sku_code                        VARCHAR(50)     NOT NULL,
    sku_group                       VARCHAR(50)     ,

    xls                             BOOLEAN         DEFAULT FALSE,
    original_quantity               INT             NOT NULL,
    request_quantity                INT             NOT NULL,
    pending_quantity                INT             ,
    delivered_quantity              INT             ,
    refused_quantity                INT             ,

    expected_backoffice_date        TIMESTAMP       ,
    backoffice_date                 TIMESTAMP       ,
    expected_delivery_date          TIMESTAMP       ,
    delivered_date                  TIMESTAMP       ,

    refusal_code                    VARCHAR(20)     ,
    refusal_reason                  VARCHAR(200)    ,
    refusal_type                    VARCHAR(200)    ,

    error_code                      VARCHAR(50)     ,
    error_message                   TEXT            ,

    created_at                      TIMESTAMP       NOT NULL,
    updated_at                      TIMESTAMP       NOT NULL
);

-- PRIMARY KEYS
ALTER TABLE purchase_order ADD CONSTRAINT purchase_order_pk PRIMARY KEY (id);
ALTER TABLE purchase_order_item ADD CONSTRAINT purchase_order_item_pk PRIMARY KEY (id);
ALTER TABLE fulfillment ADD CONSTRAINT fulfillment_pk PRIMARY KEY (id);
ALTER TABLE fulfillment_item ADD CONSTRAINT fulfillment_item_pk PRIMARY KEY (id);

-- FOREIGN KEYS FOR purchase_order_item
ALTER TABLE purchase_order_item ADD CONSTRAINT fk_purchase_order_item__purchase_order_id
FOREIGN KEY (purchase_order_id) REFERENCES purchase_order(id);
-- END FOREIGN KEYS FOR purchase_order_item

-- FOREIGN KEYS FOR fulfillment
ALTER TABLE fulfillment ADD CONSTRAINT fk_fulfillment__purchase_order_id
FOREIGN KEY (purchase_order_id) REFERENCES purchase_order(id);
-- END FOREIGN KEYS FOR fulfillment

-- FOREIGN KEYS FOR fulfillment_item
ALTER TABLE fulfillment_item ADD CONSTRAINT fk_fulfillment_item__fulfillment_id
FOREIGN KEY (fulfillment_id) REFERENCES fulfillment(id);

ALTER TABLE fulfillment_item ADD CONSTRAINT fk_fulfillment_item__purchase_order_item_id
FOREIGN KEY (purchase_order_item_id) REFERENCES purchase_order_item(id);

ALTER TABLE fulfillment_item ADD CONSTRAINT fk_fulfillment_item__origin_fulfillment_item_id
FOREIGN KEY (origin_fulfillment_item_id) REFERENCES fulfillment_item(id);

ALTER TABLE fulfillment_item ADD CONSTRAINT fk_fulfillment_item__destiny_fulfillment_item_id
FOREIGN KEY (destiny_fulfillment_item_id) REFERENCES fulfillment_item(id);
-- END FOREIGN KEYS FOR fulfillment

-- SEARCH INDEXES
CREATE INDEX purchase_order__general_idx
    ON purchase_order (store_code, status, status_internal);

CREATE INDEX purchase_order_item__general_idx
    ON purchase_order_item (purchase_order_id, status, status_internal, sku_code);

CREATE INDEX fulfillment__general_idx
    ON fulfillment (purchase_order_id, status, status_internal, sales_order_identifier);

CREATE INDEX fulfillment_item__general_idx
    ON fulfillment_item (fulfillment_id, purchase_order_item_id, guid, status, status_internal);


ALTER TABLE fulfillment_item ADD CONSTRAINT uc_fulfillment_item__guid UNIQUE (guid);

-- END INDEXES


-- GRANTS
GRANT SELECT, INSERT, UPDATE, DELETE on purchase_order to template_readwrite;
GRANT SELECT, INSERT, UPDATE, DELETE on purchase_order_item to template_readwrite;
GRANT SELECT, INSERT, UPDATE, DELETE on fulfillment to template_readwrite;
GRANT SELECT, INSERT, UPDATE, DELETE on fulfillment_item to template_readwrite;

GRANT SELECT on purchase_order to template_readonly;
GRANT SELECT on purchase_order_item to template_readonly;
GRANT SELECT on fulfillment to template_readonly;
GRANT SELECT on fulfillment_item to template_readonly;

-- END GRANTS
