//package com.bncn.inditex.service;
//
//import com.bncn.inditex.entity.Customer;
//import com.bncn.inditex.events.Event;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//  YA NO LA ESTOY USANDO. PK AL AÑADIR AVRO QUIERO QUE ME CONSUMA EL PROPIO CUSTOMER GENERADO EN /avro/Customer
//@Data
////anotación de Lombok para métodos equals y hashCode para comparar objetos o los utilizas en colecciones como HashMap, HashSet o LinkedList.
////Si Event<Customer> tiene un campo, digamos id, y ConsumerEventService no tiene campos adicionales, al usar @EqualsAndHashCode(callSuper = true), el método equals() comparará los objetos ConsumerEventService basándose en los campos de la clase Event, como id.
//@EqualsAndHashCode(callSuper = true)
//public class ConsumerEventService extends Event<Customer> {
//}
