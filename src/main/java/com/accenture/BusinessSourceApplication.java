package com.accenture;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
public class BusinessSourceApplication {
	
	//private static final Logger logger = LoggerFactory.getLogger(BusinessSourceApplication.class);
	
	private static final Random RANDOM = new Random(System.currentTimeMillis());

	private static final String[] data = new String[] { 
			"0500400001NNNNNNNN1V000Z  24755421277152772714556100037191003000000069039840000000069039840HILTON GV TVVS LN SVC    ORLANDO      US 350432821FL  11000N0060702 1 0112780",
			"0600400002NNNNNNNN2V000   24011341277000019758722100699171003000000001699840000000001699840UDEMY: ONLINE COURSES    HTTPSWWW.UDEMUS 829994107CA   1000N0043710 4 0112780",
			"0700BBBBBBNNNNNNNN3V000Z  74934851277569535110003000000001004000000013536840000010750000152CASTILLO 1094    .       VALDIVIA     CL 601100000   9 1000E0429175   051278H",
			"0500400003NNNNNNNN4V000Z  24234261277000000470759423426001004000000073999032000000073999032MERCADOPAGO*WORLDSEG     BUENOS AIRES AR 507200000     1008N006645  4   12780",
			"0500400004NNNNNNNN5V000Z  24234261277000000459240423426001004000000219600032000000219600032MERCADOPAGO*ROMIP        BUENOS AIRES AR 521100000     1008N824480  4   12780"
			};

	public static void main(String[] args) {
		SpringApplication.run(BusinessSourceApplication.class, args);
	}
	
	@Bean
	public Supplier<Message<String>> readTransactions() {
		return () -> {
			String value = data[RANDOM.nextInt(data.length)];
			return MessageBuilder.withPayload(value).build();
		};
	}

}
