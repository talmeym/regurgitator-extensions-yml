# regurgitator-extensions-yml

regurgitator is a lightweight, modular, extendable java framework that you configure to 'regurgitate' canned or clever responses to incoming requests; useful for quickly mocking or prototyping services without writing any code. simply configure, deploy and run.

start your reading here: [regurgitator-all](https://talmeym.github.io/regurgitator-all#regurgitator)

## extension steps in yml

### json-parameter

a json-parameter creates a parameter, extracting it's value from within a json document, using json-path:

```yml
json-parameter:
 name: book-name
 source: book-catalogue
 json-path: $.catalogue.book.name
```

### xml-parameter

an xml-parameter creates a parameter, extracting it's value from within an xml document, using xpath:

```yml
xml-parameter:
 name: book-name
 source: book-catalogue
 xpath: /bk:catalogue/bk:book/bk:name
  namespaces:
   bk: http://books.com
```

## extension constructs in yml

### freemarker-builder 

a freemarker-builder aggregates parameter values together using a freemarker template.

```yml
freemarker-builder:
 source: template-param

freemarker-builder:
 file: classpath:/template.ftl

freemarker-builder:
 value: This is a ${descriptive} day
```

a freemarker-builder can use the same value source properties as other steps, such as ``create-parameter``, getting its template text from a source parameter, a file or an explicit value.

a freemarker-builder builds from just the ``parameters`` context by default. if the ``all-contexts`` property is true, all context data is made available to the builder, with dashes replaced by underscores in context names, and the colon separating context and parameter names replaced with a period, eg. ``request-metadata:method`` becomes ``request_metadata.method`` when referenced in the template.

```yml
freemarker-builder:
 all-contexts: true
 value: <response><payload>${response_payload.text}</payload><status-code>${response_metadata.status_code}</status-code><content-type>${response_metadata.content_type}</content-type></response>

```

### velocity-builder

a freemarker-builder aggregates parameter values together using a freemarker template.

```yml
velocity-builder:
 source: template-param

velocity-builder:
 file: classpath:/template.ftl

velocity-builder:
 value: This is a ${descriptive} day
```

a velocity-builder can use the same value source properties as other steps, such as ``create-parameter``, getting its template text from a source parameter, a file or an explicit value.

a velocity-builder builds from just the ``parameters`` context by default. if the ``all-contexts`` property is true, all context data is made available to the builder, with dashes replaced by underscores in context names, and the colon separating context and parameter names replaced with a period, eg. ``request-metadata:method`` becomes ``request_metadata.method`` when referenced in the template.

```yml
velocity-builder:
 all-contexts: true
 value: <response><payload>${response_payload.text}</payload><status-code>${response_metadata.status_code}</status-code><content-type>${response_metadata.content_type}</content-type></response>

```

### json-path-processor

a json-path-processor processes a parameter value, extracting a value from it using json path.

```yml
create-parameter:
 name: book-name
 source: book-catalogue
 processor:
  json-path-processor:
   json-path: $.catalogue.book.name
```

### xpath-processor

an xpath-processor processes a parameter value, extracting a value from it using xpath.

```yml
create-parameter:
 name: book-name
 source: book-catalogue
 processor:
  xpath-processor:
   xpath: /cat:atalogue/bk:book/@name
   namespaces: cat=http://catalogues.com,bk=http://books.com
```

namespaces for an xpath-processor can also be declared as a object property of the processor:

```yml
create-parameter:
 name: book-name
 source: book-catalogue
 processor:
  xpath-processor:
   xpath: /cat:atalogue/bk:book/@name
   namespaces:
    cat: http://catalogues.com
    bk: http://books.com
```

### freemarker-processor

a freemarker-processor processes a parameter value, formatting the value using a freemarker template.

```yml
create-response:
 source: unformatted-response
 processor:
  freemarker-processor:
   file: classpath:/template.ftl

create-response:
 source: unformatted-response
 processor:
  freemarker-processor:
   value: The response was: ${value}
```

the parameter value is made available to the template as simply ``value``. the template text can be specified in a ``value`` property or drawn in from a file.

### velocity-processor

a velocity-processor processes a parameter value, formatting the value using a velocity template.

```yml
create-response:
 source: unformatted-response
 processor:
  velocity-processor:
   file: classpath:/template.ftl

create-response:
 source: unformatted-response
 processor:
  velocity-processor:
   value: The response was: ${value}
```

the parameter value is made available to the template as simply ``value``. the template text can be specified in a ``value`` property or drawn in from a file.

### xml-schema-validator

an xml-schema-validator is a ``value-processor`` that validates a parameter value against an xml-schema file.

```yml
create-response:
 source: response
 processor:
  xml-schema-validator:
   file: classpath:/response_schema.xsd
```

validating a parameter value can be useful in ensuring that your configured logic and processing always returns valid responses. if the value fails validation, an exception is thrown; if it passes, the value is passed through unchanged.
