FROM java:8
COPY Client.java /
RUN javac Client.java
EXPOSE 25000
ENTRYPOINT ["java"]
CMD ["Client"]