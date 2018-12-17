/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package BigDataDemo.avro;
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class User extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"BigDataDemo.avro\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"age\",\"type\":[\"int\",\"null\"]},{\"name\":\"email\",\"type\":[\"string\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public CharSequence name;
  @Deprecated public Integer age;
  @Deprecated public CharSequence email;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public User() {}

  /**
   * All-args constructor.
   */
  public User(CharSequence name, Integer age, CharSequence email) {
    this.name = name;
    this.age = age;
    this.email = email;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return age;
    case 2: return email;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: name = (CharSequence)value$; break;
    case 1: age = (Integer)value$; break;
    case 2: email = (CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   */
  public CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'age' field.
   */
  public Integer getAge() {
    return age;
  }

  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(Integer value) {
    this.age = value;
  }

  /**
   * Gets the value of the 'email' field.
   */
  public CharSequence getEmail() {
    return email;
  }

  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(CharSequence value) {
    this.email = value;
  }

  /** Creates a new User RecordBuilder */
  public static BigDataDemo.avro.User.Builder newBuilder() {
    return new BigDataDemo.avro.User.Builder();
  }

  /** Creates a new User RecordBuilder by copying an existing Builder */
  public static BigDataDemo.avro.User.Builder newBuilder(BigDataDemo.avro.User.Builder other) {
    return new BigDataDemo.avro.User.Builder(other);
  }

  /** Creates a new User RecordBuilder by copying an existing User instance */
  public static BigDataDemo.avro.User.Builder newBuilder(BigDataDemo.avro.User other) {
    return new BigDataDemo.avro.User.Builder(other);
  }

  /**
   * RecordBuilder for User instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<User>
    implements org.apache.avro.data.RecordBuilder<User> {

    private CharSequence name;
    private Integer age;
    private CharSequence email;

    /** Creates a new Builder */
    private Builder() {
      super(BigDataDemo.avro.User.SCHEMA$);
    }

    /** Creates a Builder by copying an existing Builder */
    private Builder(BigDataDemo.avro.User.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.age)) {
        this.age = data().deepCopy(fields()[1].schema(), other.age);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.email)) {
        this.email = data().deepCopy(fields()[2].schema(), other.email);
        fieldSetFlags()[2] = true;
      }
    }

    /** Creates a Builder by copying an existing User instance */
    private Builder(BigDataDemo.avro.User other) {
            super(BigDataDemo.avro.User.SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.age)) {
        this.age = data().deepCopy(fields()[1].schema(), other.age);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.email)) {
        this.email = data().deepCopy(fields()[2].schema(), other.email);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'name' field */
    public CharSequence getName() {
      return name;
    }

    /** Sets the value of the 'name' field */
    public BigDataDemo.avro.User.Builder setName(CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /** Checks whether the 'name' field has been set */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }

    /** Clears the value of the 'name' field */
    public BigDataDemo.avro.User.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'age' field */
    public Integer getAge() {
      return age;
    }

    /** Sets the value of the 'age' field */
    public BigDataDemo.avro.User.Builder setAge(Integer value) {
      validate(fields()[1], value);
      this.age = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /** Checks whether the 'age' field has been set */
    public boolean hasAge() {
      return fieldSetFlags()[1];
    }

    /** Clears the value of the 'age' field */
    public BigDataDemo.avro.User.Builder clearAge() {
      age = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'email' field */
    public CharSequence getEmail() {
      return email;
    }

    /** Sets the value of the 'email' field */
    public BigDataDemo.avro.User.Builder setEmail(CharSequence value) {
      validate(fields()[2], value);
      this.email = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /** Checks whether the 'email' field has been set */
    public boolean hasEmail() {
      return fieldSetFlags()[2];
    }

    /** Clears the value of the 'email' field */
    public BigDataDemo.avro.User.Builder clearEmail() {
      email = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public User build() {
      try {
        User record = new User();
        record.name = fieldSetFlags()[0] ? this.name : (CharSequence) defaultValue(fields()[0]);
        record.age = fieldSetFlags()[1] ? this.age : (Integer) defaultValue(fields()[1]);
        record.email = fieldSetFlags()[2] ? this.email : (CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}