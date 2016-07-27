package com.net;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 业务流水生成器
 * 
 * @author Administrator
 *
 */
public class SeriesNumberGenerator {

	public final static String createSeriesNumber() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		StringBuilder builder = new StringBuilder(32);
		builder.append(simpleDateFormat.format(new Date()));
		builder.append(System.currentTimeMillis());
		builder.append((Math.random() * 9 + 1) * 10000);
		return builder.toString();

	}
}
