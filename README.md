<h1>📦 Kafka JSON Messaging with Spring Boot</h1>

<p>This Spring Boot application demonstrates how to produce and consume JSON messages using <strong>Apache Kafka</strong>. It includes a REST controller to publish JSON-formatted data to a Kafka topic and a consumer service to listen and log incoming messages.</p>

<h2>🛠 Project Structure</h2>
<ul>
  <li><strong>KafkaController</strong> (<code>KfkaController.java</code>):<br>
    Exposes a REST endpoint (<code>/Kafka/Publish</code>) that accepts a <code>User</code> object as a JSON payload and sends it to a Kafka topic.</li>
  <li><strong>KafkaProducer</strong> (<code>KafkaProducer.java</code>):<br>
    Sends <code>User</code> data to the Kafka topic (<code>JSON_Topic</code>) using a <code>KafkaTemplate</code>. The message is constructed with headers to specify the topic.</li>
  <li><strong>KafkaConsumer</strong> (<code>KafkaConsumer.java</code>):<br>
    Listens for incoming messages from the <code>JSON_Topic</code>. Upon receiving a message, it prints the <code>User</code> object to the console.</li>
  <li><strong>KafkaConfig</strong> (<code>TopicConfig.java</code>):<br>
    Defines a Kafka topic bean named <code>JSON_Topic</code> using Spring Kafka’s <code>TopicBuilder</code>.</li>
</ul>

<h2>📥 Publishing JSON Messages</h2>
<p>You can publish a <code>User</code> JSON message by sending a <code>POST</code> request:</p>

<pre><code>POST http://localhost:8080/Kafka/Publish
Content-Type: application/json

{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com"
}
</code></pre>

<p><strong>Note:</strong> Ensure the <code>User</code> class exists with proper getters/setters and Jackson annotations if necessary.</p>

<h2>🧪 Consumer Output</h2>
<p>Once the message is published, the consumer will log the message to the console:</p>

<pre><code>Consumed JSON message: User{id=1, name='John Doe', email='john.doe@example.com'}
</code></pre>

<h2>🧰 Requirements</h2>
<ul>
  <li>Java 17+</li>
  <li>Spring Boot</li>
  <li>Apache Kafka (running locally or remotely)</li>
  <li>Kafka dependencies in <code>pom.xml</code> (<code>spring-kafka</code>, etc.)</li>
</ul>

<h2>💡 Notes</h2>
<ul>
  <li>Group ID is set to <code>my-group1</code> in the consumer for offset tracking.</li>
  <li>Topic name is <code>JSON_Topic</code>, hardcoded in both the producer and consumer.</li>
  <li>This setup assumes a working local Kafka instance.</li>
</ul>
