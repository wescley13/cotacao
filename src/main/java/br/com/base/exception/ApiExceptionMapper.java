package br.com.base.exception;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class ApiExceptionMapper
    implements ResponseExceptionMapper<ApiException> {

  @Override
  public boolean handles(int status, MultivaluedMap<String, Object> headers) {
    return status >= 400;
  }

  @Override
  public ApiException toThrowable(Response response) {
    return new ApiException(response);
  }
}
