package com.template.demo.domain.type

enum class DeliveryChannelType(val code: Int, val description: String) {
    DC_1(1, "Loja Física"),
    DC_2(2, "Loja E-com"),
    DC_3(3, "Venda Direta"),
    DC_4(4, "B2B"),
    DC_5(5, "Inter e Intra Company"),
    DC_6(6, "Serviços"),
    DC_7(7, "Outros"),
    DC_99(99, "Não Informado")
}
