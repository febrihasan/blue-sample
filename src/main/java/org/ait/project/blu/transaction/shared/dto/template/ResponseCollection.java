package org.ait.project.blu.transaction.shared.dto.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCollection<T>{

	@JsonProperty("pagination")
	private PaginationConfig paginationConfig;

	@JsonProperty("content")
	private Flux<T> content;
}