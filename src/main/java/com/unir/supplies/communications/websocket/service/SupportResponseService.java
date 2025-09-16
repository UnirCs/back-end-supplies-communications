package com.unir.supplies.communications.websocket.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class SupportResponseService {

    private final Random random = new Random();

    private final List<String> greetingResponses = Arrays.asList(
        "¡Hola! Soy el agente de soporte técnico. ¿En qué puedo ayudarte hoy?",
        "¡Buenos días! Estoy aquí para resolver cualquier duda que tengas.",
        "¡Hola! Bienvenido al soporte técnico de UNIR Supplies. ¿Cómo te puedo asistir?"
    );

    private final List<String> orderResponses = Arrays.asList(
        "Entiendo que tienes una consulta sobre tu pedido. ¿Podrías proporcionarme el número de pedido?",
        "Puedo ayudarte con información sobre tu pedido. ¿Cuál es el número de referencia?",
        "Para revisar el estado de tu pedido, necesitaré el ID del mismo. ¿Lo tienes a mano?"
    );

    private final List<String> productResponses = Arrays.asList(
        "Te puedo ayudar con información sobre nuestros productos. ¿Qué producto específico te interesa?",
        "Tenemos una amplia gama de suministros. ¿Hay algún producto en particular que estés buscando?",
        "Estaré encantado de ayudarte con información sobre productos. ¿Qué necesitas saber?"
    );

    private final List<String> shippingResponses = Arrays.asList(
        "Para consultas de envío, puedo verificar el estado de tu paquete. ¿Tienes el número de seguimiento?",
        "Los envíos suelen tardar entre 3-5 días hábiles. ¿Necesitas información específica sobre algún envío?",
        "Puedo ayudarte con información de envío. ¿Cuál es tu consulta específica?"
    );

    private final List<String> generalResponses = Arrays.asList(
        "Entiendo tu consulta. Déjame revisar esa información por ti.",
        "Gracias por contactarnos. Estoy revisando tu solicitud.",
        "He recibido tu mensaje. Te ayudo a resolver esto de inmediato.",
        "Perfecto, voy a buscar esa información para ti.",
        "Estoy aquí para ayudarte. Permíteme un momento para revisar los detalles."
    );

    private final List<String> closingResponses = Arrays.asList(
        "¿Hay algo más en lo que pueda ayudarte hoy?",
        "Espero haber resuelto tu consulta. ¿Necesitas ayuda con algo más?",
        "¿Te ha sido útil mi respuesta? ¿Tienes alguna otra pregunta?"
    );

    public String generateResponse(String userMessage) {
        String message = userMessage.toLowerCase();

        // Detectar tipo de consulta y responder apropiadamente
        if (isGreeting(message)) {
            return getRandomResponse(greetingResponses);
        } else if (isOrderRelated(message)) {
            return getRandomResponse(orderResponses);
        } else if (isProductRelated(message)) {
            return getRandomResponse(productResponses);
        } else if (isShippingRelated(message)) {
            return getRandomResponse(shippingResponses);
        } else if (isClosing(message)) {
            return getRandomResponse(closingResponses);
        } else {
            return getRandomResponse(generalResponses);
        }
    }

    private boolean isGreeting(String message) {
        return message.contains("hola") || message.contains("buenos") ||
               message.contains("buenas") || message.contains("saludos");
    }

    private boolean isOrderRelated(String message) {
        return message.contains("pedido") || message.contains("orden") ||
               message.contains("compra") || message.contains("estado");
    }

    private boolean isProductRelated(String message) {
        return message.contains("producto") || message.contains("artículo") ||
               message.contains("item") || message.contains("catálogo") ||
               message.contains("precio") || message.contains("disponibilidad");
    }

    private boolean isShippingRelated(String message) {
        return message.contains("envío") || message.contains("entrega") ||
               message.contains("enviar") || message.contains("recibir") ||
               message.contains("seguimiento") || message.contains("tracking");
    }

    private boolean isClosing(String message) {
        return message.contains("gracias") || message.contains("perfecto") ||
               message.contains("resuelto") || message.contains("ya está") ||
               message.contains("adiós") || message.contains("hasta luego");
    }

    private String getRandomResponse(List<String> responses) {
        return responses.get(random.nextInt(responses.size()));
    }
}
