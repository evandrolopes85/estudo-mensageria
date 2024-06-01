package com.ms.email.dto;

public record EmailRecordDto(Integer idUser,
							 String emailTo,
							 String subject,
							 String text) {

}
