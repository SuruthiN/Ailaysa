package com.ailaysa.task.Ailaysa.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkdownDocument {
	private String plainText;

	public MarkdownDocument(String plainText) {
		super();
		this.plainText = plainText;
	}
	
}
