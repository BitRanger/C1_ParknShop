/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.mail;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;


/**
 *@author BowenCai
 *@since 10:35:54 AM
 */
public class EMailSender {

	private static final Logger LOG = LoggerFactory.getLogger(EMailSender.class);
	
	@Autowired
	JavaMailSender sender;


	public boolean send(String address, String subject, String content) {
		
		LOG.debug("sending message [" + subject + "] to [" + address + "]");
		
		MimeMessage msg = sender.createMimeMessage();
		
		try {
			msg.setRecipient(RecipientType.TO, new InternetAddress(address));
			msg.setSubject(subject);
			msg.setText(content);
			
			sender.send(msg);
			
		} catch (Exception e) {
			LOG.error("failed sending email to [" 
					+ address + "]" + " subject [" 
					+ subject + "] content[" 
					+ content + "]");
			return false;
		}
		return false;
	}
	
	
	/**
	 * @return the sender
	 */
	public JavaMailSender getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}
}
