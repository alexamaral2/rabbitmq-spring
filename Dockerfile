FROM rabbitmq:4.2-management

RUN apt-get update && apt-get install -y curl
RUN curl -L https://github.com/rabbitmq/rabbitmq-delayed-message-exchange/releases/download/v4.2.0/rabbitmq_delayed_message_exchange-4.2.0.ez > /plugins/rabbitmq_delayed_message_exchange-4.2.0.ez
RUN rabbitmq-plugins enable --offline rabbitmq_delayed_message_exchange