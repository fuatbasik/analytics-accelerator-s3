package com.amazon.connector.s3.common.telemetry;

/** a {@link TelemetryReporter} that does nothing. */
class NoOpTelemetryReporter implements TelemetryReporter {
  /**
   * Reports the start of an operation
   *
   * @param epochTimestampNanos wall clock time for the operation start
   * @param operation and instance of {@link Operation} to start
   */
  @Override
  public void reportStart(long epochTimestampNanos, Operation operation) {}

  /**
   * Reports the completion of an operation
   *
   * @param operationMeasurement an instance of {@link OperationMeasurement}.
   */
  @Override
  public void reportComplete(OperationMeasurement operationMeasurement) {}
}