﻿ALTER TABLE PRODUCT_STOCK ADD COLUMN PS_STOREROOM_ID VARCHAR(255) NOT NULL;
ALTER TABLE PRODUCT_STOCK DROP COLUMN PS_PRODUCT_ID;
ALTER TABLE PRODUCT_STOCK ADD COLUMN PS_PRODUCT_ID VARCHAR(255) NOT NULL;