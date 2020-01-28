package com.jwt.jwtauth.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public enum ChannelType {
	DESKTOP("D"), MOBILE("M"), ANDROID("A"), IPHONE("I"), API("P");

	private String code;

	private ChannelType(String code) {
		this.code = code;
	}

	public static ChannelType getEnumFromCode(String code) {
		code = code.toUpperCase();
		for (ChannelType channelType : ChannelType.values()) {
			if (channelType.getCode().equals(code) || channelType.getName().equalsIgnoreCase(code))
				return channelType;
		}
		return null;
	}

	/**
	 * Get Channel Type
	 * 
	 * @param codeOrName
	 *            { we can pass the name or code}
	 * @return ChannelType
	 */
	public static ChannelType getChannelType(String codeOrName) {
		ChannelType channelType = getEnumFromCode(codeOrName);

		if (channelType != null) {
			try {
				channelType = ChannelType.valueOf(codeOrName);
			} catch (Exception e) {
			}
		}
		return channelType;
	}

	public static List<String> getCodes(List<ChannelType> channelTypes) {
		List<String> channelCodes = new ArrayList<>();
		channelTypes.forEach(channelType -> {
			channelCodes.add(channelType.getCode());
		});
		return channelCodes;
	}

	public String getName() {
		return this.name();
	}
}
