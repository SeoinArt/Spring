package com.multi.domain;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="melon_230601")
public class MelonVO {
	
	@Id
	private String id;
	
	@BsonProperty
	private String ranking;
	
	@BsonProperty
	private String songTitle;
	
	@BsonProperty
	private String singer;
	
	@BsonProperty
	private String albumImage;
	
	@BsonProperty
	private String crawlingTime;
	
	
}
