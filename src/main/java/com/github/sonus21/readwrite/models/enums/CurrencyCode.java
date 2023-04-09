package com.github.sonus21.readwrite.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CurrencyCode {
    INR(1), USD(4), EUR(5), AED(6), DZD(7), AFN(8), AOA(9), XCD(10), ARS(11), AMD(12), AWG(13), AUD(14), AZN(15), BSD(16), BHD(17), BDT(18), BBD(19), BYN(20), BZD(21), XOF(22), BMD(23), BTN(24), BOB(25), BOV(26), BAM(27), BWP(28), NOK(29), BRL(30), BND(31), BGN(32), BIF(33), CVE(34), KHR(35), XAF(36), CAD(37), KYD(38), CLP(39), CLF(40), CNY(41), COP(42), COU(43), KMF(44), CDF(45), NZD(46), CRC(47), HRK(48), CUP(49), CUC(50), ANG(51), CZK(52), DKK(53), DJF(54), DOP(55), EGP(56), SVC(57), ERN(58), SZL(59), ETB(60), FKP(61), FJD(62), XPF(63), GMD(64), GEL(65), GHS(66), GIP(67), GTQ(68), GBP(69), GNF(70), GYD(71), HTG(72), HNL(73), HKD(74), HUF(75), ISK(76), IDR(77), XDR(78), IRR(79), IQD(80), ILS(81), JMD(82), JPY(83), JOD(84), KZT(85), KES(86), KPW(87), KRW(88), KWD(89), KGS(90), LAK(91), LBP(92), LSL(93), ZAR(94), LRD(95), LYD(96), CHF(97), MOP(98), MKD(99), MGA(100), MWK(101), MYR(102), MVR(103), MRU(104), MUR(105), XUA(106), MXN(107), MXV(108), MDL(109), MNT(110), MAD(111), MZN(112), MMK(113), NAD(114), NPR(115), NIO(116), NGN(117), OMR(118), PKR(119), PAB(120), PGK(121), PYG(122), PEN(123), PHP(124), PLN(125), QAR(126), RON(127), RUB(128), RWF(129), SHP(130), WST(131), STN(132), SAR(133), RSD(134), SCR(135), SLL(136), SLE(137), SGD(138), XSU(139), SBD(140), SOS(141), SSP(142), LKR(143), SDG(144), SRD(145), SEK(146), CHE(147), CHW(148), SYP(149), TWD(150), TJS(151), TZS(152), THB(153), TOP(154), TTD(155), TND(156), TRY(157), TMT(158), UGX(159), UAH(160), ALL(161), USN(162), UYU(163), UYI(164), UYW(165), UZS(166), VUV(167), VES(168), VED(169), VND(170), YER(171), ZMW(172), ZWL(173), XBA(174), XBB(175), XBC(176), XBD(177), XTS(178), XXX(179), XAU(180), XPD(181), XPT(182), XAG(183);

    private final int value;

    @JsonCreator
    public static CurrencyCode create(String code) {
        return CurrencyCode.valueOf(code);
    }

}
