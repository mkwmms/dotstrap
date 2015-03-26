/**
 * GetFieldsResponse.java
 * JRE v1.8.0_40
 * 
 * Created by William Myers on Mar 24, 2015.
 * Copyright (c) 2015 William Myers. All Rights reserved.
 */
package shared.communication;

import java.util.List;

import shared.model.Field;
import shared.model.User;


/**
 * The Class GetFieldsResponse.
 */
public class GetFieldsResponse implements Response {
  private User        user;
  private List<Field> fields;

  /**
   * Instantiates a new gets the fields result.
   */
  public GetFieldsResponse() {
    fields = null;
  }

  /**
   * Instantiates a new gets the fields response.
   *
   * @param fields the fields
   */
  public GetFieldsResponse(List<Field> fields) {
    this.fields = fields;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Field> getFields() {
    return fields;
  }

  public void setFields(List<Field> fields) {
    this.fields = fields;
  }

  /**
   *
   * (non-Javadoc).
   *
   * @return the string
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Field f : fields) {
      sb.append(f.getProjectId() + "\n");
      sb.append(f.getFieldId() + "\n");
      sb.append(f.getTitle() + "\n");
    }
    return sb.toString();
  }
}
