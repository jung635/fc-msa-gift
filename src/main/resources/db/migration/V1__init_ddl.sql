-- gifts
CREATE SEQUENCE gifts_seq;
create table gifts
(
    id                  bigint primary key default nextval('gifts_seq'),
    gift_token          varchar(255) not null,
    buyer_user_id       varchar(255) not null,
    order_token         varchar(255) not null,
    status              varchar(30)  not null default 'INIT',
    push_type           varchar(30)  not null default 'KAKAO',
    gift_receiver_name  varchar(255) not null,
    gift_receiver_phone varchar(255) not null,
    gift_message        varchar(255) not null,
    receiver_name       varchar(30) null,
    receiver_phone      varchar(30) null,
    receiver_zipcode    varchar(10) null,
    receiver_address1   varchar(255) null,
    receiver_address2   varchar(255) null,
    etc_message         varchar(255) null,
    paid_at             timestamp(6) null,
    pushed_at           timestamp(6) null,
    accepted_at         timestamp(6) null,
    expired_at          timestamp(6) null,
    created_at          timestamp(6) not null,
    updated_at          timestamp(6) null
);

COMMENT ON COLUMN gifts.id IS 'ID';
COMMENT ON COLUMN gifts.gift_token IS 'gift_token';
COMMENT ON COLUMN gifts.buyer_user_id IS '구매자 아이디';
COMMENT ON COLUMN gifts.order_token IS 'order_token';
COMMENT ON COLUMN gifts.status IS '상태';
COMMENT ON COLUMN gifts.push_type IS '푸시타입';
COMMENT ON COLUMN gifts.gift_receiver_name IS '선물 수령자명';
COMMENT ON COLUMN gifts.gift_receiver_phone IS '선물 수령자 휴대폰번호';
COMMENT ON COLUMN gifts.gift_message IS '선물 메시지';
COMMENT ON COLUMN gifts.receiver_name IS '수령자명';
COMMENT ON COLUMN gifts.receiver_phone IS '수령자 휴대폰번호';
COMMENT ON COLUMN gifts.receiver_zipcode IS '수령자 우편번호';
COMMENT ON COLUMN gifts.receiver_address1 IS '수령자 주소1';
COMMENT ON COLUMN gifts.receiver_address2 IS '수령자 주소2';
COMMENT ON COLUMN gifts.etc_message IS '남기는 말';
COMMENT ON COLUMN gifts.paid_at IS '구매 일시';
COMMENT ON COLUMN gifts.pushed_at IS '푸시발송 일시';
COMMENT ON COLUMN gifts.accepted_at IS '수락 일시';
COMMENT ON COLUMN gifts.expired_at IS '만료 일시';
COMMENT ON COLUMN gifts.created_at IS '생성 일시';
COMMENT ON COLUMN gifts.updated_at IS '수정 일시';
COMMENT ON TABLE gifts IS 'gifts';

create
index gifts_idx01 on gifts (created_at);

create
index gifts_idx02 on gifts (updated_at);

create
index gifts_idx03 on gifts (gift_token);

create
index gifts_idx04 on gifts (order_token);