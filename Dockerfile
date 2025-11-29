FROM openjdk:26-ea-jdk

ENV WILDFLY_VERSION=38.0.0.Final
ENV WILDFLY_HOME=/opt/wildfly

RUN curl -LO https://github.com/wildfly/wildfly/releases/download/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
  && tar -xzf wildfly-$WILDFLY_VERSION.tar.gz -C /opt/ \
  && mv /opt/wildfly-$WILDFLY_VERSION $WILDFLY_HOME \
  && rm wildfly-$WILDFLY_VERSION.tar.gz

ENV PATH="$WILDFLY_HOME/bin:$PATH"

EXPOSE 8080 9990

CMD ["standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]


