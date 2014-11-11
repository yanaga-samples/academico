FROM marcondesmacaneiro/unidavi_academico:1

EXPOSE 8080

CMD ["/sbin/my_init", "--", "/srv/tomcat/bin/catalina.sh", "run"]
