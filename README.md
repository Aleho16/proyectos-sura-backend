# proyectos-sura-backend
1. laboratorio solid
   Contexto del Negocio: Una plataforma de streaming necesita un módulo backend para procesar el pago de las suscripciones mensuales de sus clientes. El sistema debe cobrar el monto de la suscripción, registrar la transacción en el historial y notificar al cliente.
 
Reglas de Negocio
Existen diferentes planes de suscripción (Ej: PlanBasico de $10 y PlanPremium de $20).
El cliente puede elegir pagar usando diferentes métodos: Tarjeta de Crédito, Saldo en Billetera Virtual o Transferencia Bancaria.
Un cliente no puede suscribirse a un plan si su cuenta se encuentra en estado inactivo.
Un cliente no puede suscribirse si el método de pago falla o si los fondos son insuficientes en dicho método.
Una vez que el pago es exitoso, se debe generar un registro (simular guardarlo en una base de datos) y se debe enviar una notificación al cliente (simular el envío de un Email).
 
Restricciones Técnicas (Criterios de Evaluación)
Excepciones Unchecked: Debes crear al menos dos excepciones personalizadas (que no obliguen el uso de try-catch en la firma de los métodos). Estas deben lanzarse obligatoriamente si se violan las reglas de negocio 3 o 4.
Principio de Responsabilidad Única (SRP): Está estrictamente prohibido que la clase que procesa el cobro sea la misma que guarda en la base de datos o la que envía el correo electrónico.
Principio Abierto/Cerrado (OCP) e Inversión de Dependencias (DIP): El motor que procesa el pago no debe saber si está cobrando con Tarjeta o Billetera Virtual. El diseño debe permitir que en el futuro agreguemos cobros con "Criptomonedas" sin tener que modificar ni una sola línea de la clase procesadora principal. De igual forma, el motor no debe saber si la notificación se envía por Email o por SMS.
Sustitución de Liskov (LSP) y Segregación de Interfaces (ISP): Asegúrate de que las interfaces que crees sean pequeñas y específicas. Si un método de pago no requiere validación de PIN, no obligues a esa clase a implementar un método validarPin() que quede vacío o lance un error.
tiene menú contextual
