package com.amazon.connector.s3;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/** Configuration for {@link ObjectClient} */
@Getter
@Builder
@EqualsAndHashCode
public class ObjectClientConfiguration {
  private static final String DEFAULT_USER_AGENT_PREFIX = null;

  /** User Agent Prefix. {@link ObjectClientConfiguration#DEFAULT_USER_AGENT_PREFIX} by default. */
  @Builder.Default private String userAgentPrefix = DEFAULT_USER_AGENT_PREFIX;

  public static final ObjectClientConfiguration DEFAULT =
      ObjectClientConfiguration.builder().build();

  /**
   * Construct {@link ObjectClientConfiguration}
   *
   * @param userAgentPrefix Prefix to prepend to ObjectClient's userAgent.
   */
  @Builder
  private ObjectClientConfiguration(String userAgentPrefix) {
    this.userAgentPrefix = userAgentPrefix;
  }
}