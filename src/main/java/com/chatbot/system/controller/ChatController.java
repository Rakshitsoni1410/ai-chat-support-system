package com.chatbot.system.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.chatbot.system.model.ChatMessage;
import com.chatbot.system.repository.ChatRepository;
import com.chatbot.system.service.ChatService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatRepository chatRepository;

    @PostMapping("/send")
    public ChatMessage sendMessage(
            @RequestParam String message,
            Authentication authentication) {

        System.out.println("USER => " + authentication.getName());

        String lower = message.toLowerCase().trim();

        String response;

        // ================= GREETINGS =================

        if (lower.contains("hello") || lower.contains("hi")) {

            response =
                    "Hello 👋 Welcome! I'm your smart AI assistant.\n\n"
                            + "I can help you with:\n"
                            + "• Programming 💻\n"
                            + "• Studies 📚\n"
                            + "• Motivation 🚀\n"
                            + "• Daily life questions 😊\n"
                            + "• Fun and jokes 😂\n\n"
                            + "How can I help you today?";

        } else if (lower.contains("good morning")) {

            response =
                    "Good morning ☀️\n\n"
                            + "Wishing you a happy, energetic, and productive day ahead.";

        } else if (lower.contains("good afternoon")) {

            response =
                    "Good afternoon 😊\n\n"
                            + "Hope your day is going great.";

        } else if (lower.contains("good evening")) {

            response =
                    "Good evening 🌇\n\n"
                            + "Relax and enjoy your evening.";

        } else if (lower.contains("good night")) {

            response =
                    "Good night 🌙\n\n"
                            + "Sleep peacefully and take care of yourself.";

        }

        // ================= PERSONAL =================

        else if (lower.contains("your name")) {

            response =
                    "I'm your AI assistant 🤖\n\n"
                            + "Created to help people with learning, chatting, coding, motivation, and fun conversations.";

        } else if (lower.contains("who made you")) {

            response =
                    "I was created using Java, Spring Boot, React, JWT Authentication, MySQL, and lots of hard work 😄";

        } else if (lower.contains("how are you")) {

            response =
                    "I'm doing great 😊\n\n"
                            + "Thanks for asking. How are you today?";

        } else if (lower.contains("thank")) {

            response =
                    "You're welcome 💙\n\n"
                            + "I'm always happy to help you.";

        }

        // ================= PROGRAMMING =================

        else if (lower.contains("java")) {

            response =
                    "Java ☕ is a powerful object-oriented programming language.\n\n"
                            + "It is widely used for:\n"
                            + "• Backend Development\n"
                            + "• Android Apps\n"
                            + "• Enterprise Applications\n"
                            + "• APIs and Microservices\n\n"
                            + "Java is known for security, performance, and portability.";

        } else if (lower.contains("python")) {

            response =
                    "Python 🐍 is one of the easiest and most popular programming languages.\n\n"
                            + "It is used in:\n"
                            + "• Artificial Intelligence\n"
                            + "• Machine Learning\n"
                            + "• Web Development\n"
                            + "• Automation\n"
                            + "• Data Science\n\n"
                            + "Python syntax is beginner-friendly.";

        } else if (lower.contains("react")) {

            response =
                    "React ⚛️ is a JavaScript library used to build modern user interfaces.\n\n"
                            + "Features:\n"
                            + "• Component-based architecture\n"
                            + "• Fast rendering\n"
                            + "• Reusable UI\n"
                            + "• Great for Single Page Applications";

        } else if (lower.contains("spring boot")) {

            response =
                    "Spring Boot 🚀 is a Java framework used for backend development.\n\n"
                            + "It helps developers create:\n"
                            + "• REST APIs\n"
                            + "• Secure applications\n"
                            + "• Enterprise systems\n"
                            + "• Microservices\n\n"
                            + "It reduces boilerplate code and speeds up development.";

        } else if (lower.contains("html")) {

            response =
                    "HTML 🌐 is the structure of a website.\n\n"
                            + "It creates:\n"
                            + "• Headings\n"
                            + "• Paragraphs\n"
                            + "• Images\n"
                            + "• Buttons\n"
                            + "• Forms";

        } else if (lower.contains("css")) {

            response =
                    "CSS 🎨 makes websites beautiful.\n\n"
                            + "It controls:\n"
                            + "• Colors\n"
                            + "• Layouts\n"
                            + "• Animations\n"
                            + "• Responsive Design\n"
                            + "• Fonts and Styling";

        } else if (lower.contains("javascript")) {

            response =
                    "JavaScript ⚡ makes websites interactive.\n\n"
                            + "It is used for:\n"
                            + "• Buttons\n"
                            + "• Animations\n"
                            + "• API Calls\n"
                            + "• Dynamic Content\n"
                            + "• Frontend Logic";

        } else if (lower.contains("database")) {

            response =
                    "A Database 🗄️ stores application data.\n\n"
                            + "Examples:\n"
                            + "• User Accounts\n"
                            + "• Messages\n"
                            + "• Products\n"
                            + "• Orders\n"
                            + "• Transactions";

        } else if (lower.contains("mysql")) {

            response =
                    "MySQL 🐬 is a popular relational database.\n\n"
                            + "It is fast, reliable, and widely used in web applications.";

        } else if (lower.contains("api")) {

            response =
                    "API 🔗 stands for Application Programming Interface.\n\n"
                            + "APIs allow applications to communicate with each other.";

        } else if (lower.contains("jwt")) {

            response =
                    "JWT 🔐 means JSON Web Token.\n\n"
                            + "It is used for:\n"
                            + "• Authentication\n"
                            + "• Authorization\n"
                            + "• Secure Login Systems";

        } else if (lower.contains("coding")) {

            response =
                    "Coding 💻 is the process of giving instructions to computers.\n\n"
                            + "Practice regularly and build projects to improve.";

        }

        // ================= AI =================

        else if (lower.contains("ai")) {

            response =
                    "Artificial Intelligence 🤖 allows machines to think and solve problems like humans.\n\n"
                            + "AI is used in:\n"
                            + "• Chatbots\n"
                            + "• Self-driving cars\n"
                            + "• Voice Assistants\n"
                            + "• Recommendations\n"
                            + "• Image Recognition";

        } else if (lower.contains("machine learning")) {

            response =
                    "Machine Learning 📊 is a branch of AI.\n\n"
                            + "Machines learn patterns from data and improve automatically.";

        }

        // ================= STUDY =================

        else if (lower.contains("study")) {

            response =
                    "Study Tip 📚\n\n"
                            + "• Study daily\n"
                            + "• Revise regularly\n"
                            + "• Practice questions\n"
                            + "• Avoid distractions\n"
                            + "• Stay consistent";

        } else if (lower.contains("exam")) {

            response =
                    "Exam Tips 📝\n\n"
                            + "• Stay calm\n"
                            + "• Practice previous papers\n"
                            + "• Revise important topics\n"
                            + "• Sleep properly before exams";

        } else if (lower.contains("career")) {

            response =
                    "Career Advice 🚀\n\n"
                            + "Choose a career based on:\n"
                            + "• Interest\n"
                            + "• Skills\n"
                            + "• Passion\n"
                            + "• Future Opportunities";

        }

        // ================= MOTIVATION =================

        else if (lower.contains("motivate")) {

            response =
                    "Motivation 🚀\n\n"
                            + "Success comes from consistency.\n"
                            + "Small daily improvements create big results.";

        } else if (lower.contains("sad")) {

            response =
                    "I'm sorry you're feeling sad 💙\n\n"
                            + "Take some rest, talk to loved ones, and remember better days will come.";

        } else if (lower.contains("stress")) {

            response =
                    "Stress Relief 🌿\n\n"
                            + "• Take deep breaths\n"
                            + "• Rest for a while\n"
                            + "• Focus on one thing at a time\n"
                            + "• Drink water and relax";

        } else if (lower.contains("tired")) {

            response =
                    "You deserve some rest ☕\n\n"
                            + "Recharge yourself and come back stronger.";

        }

        // ================= HEALTH =================

        else if (lower.contains("health")) {

            response =
                    "Health Tips ❤️\n\n"
                            + "• Eat healthy food\n"
                            + "• Exercise regularly\n"
                            + "• Sleep properly\n"
                            + "• Drink enough water";

        } else if (lower.contains("exercise")) {

            response =
                    "Exercise 🏃 keeps your body and mind healthy.\n\n"
                            + "Even 20 minutes daily helps a lot.";

        } else if (lower.contains("food")) {

            response =
                    "Healthy food 🍲 gives energy and keeps your body strong.";

        } else if (lower.contains("water")) {

            response =
                    "Water 💧 is very important for your body.\n\n"
                            + "Stay hydrated throughout the day.";

        }

        // ================= FUN =================

        else if (lower.contains("joke")) {

            response =
                    "😂 Joke Time:\n\n"
                            + "Why do programmers prefer dark mode?\n\n"
                            + "Because light attracts bugs 🐛";

        } else if (lower.contains("fun fact")) {

            response =
                    "😄 Fun Fact:\n\n"
                            + "Honey never spoils. Archaeologists found edible honey in ancient Egyptian tombs.";

        } else if (lower.contains("movie")) {

            response =
                    "Movies 🎬 are a great way to relax and enjoy storytelling.";

        } else if (lower.contains("music")) {

            response =
                    "Music 🎵 can improve mood, reduce stress, and help people relax.";

        } else if (lower.contains("game")) {

            response =
                    "Games 🎮 are fun and entertaining.\n\n"
                            + "Just remember to balance gaming with studies and health.";

        }

        // ================= CHILD FRIENDLY =================

        else if (lower.contains("cartoon")) {

            response =
                    "Cartoons 😄 are fun and entertaining.\n\n"
                            + "Tom and Jerry is loved by kids and adults around the world.";

        } else if (lower.contains("superhero")) {

            response =
                    "Superheroes 🦸 inspire people to be brave, kind, and helpful.";

        } else if (lower.contains("space")) {

            response =
                    "Space 🌌 is huge and mysterious.\n\n"
                            + "There are billions of stars and galaxies in the universe.";

        } else if (lower.contains("animal")) {

            response =
                    "Animals 🐶 are amazing creatures.\n\n"
                            + "Dolphins are known to be very intelligent.";

        }

        // ================= DAILY LIFE =================

        else if (lower.contains("weather")) {

            response =
                    "I cannot check live weather yet 🌤️\n\n"
                            + "But future AI integration can add live weather support.";

        } else if (lower.contains("time")) {

            response =
                    "I cannot access real-time clock yet ⏰";

        } else if (lower.contains("news")) {

            response =
                    "I don't have live news access yet 📰\n\n"
                            + "Future AI APIs can provide real-time news updates.";

        }

        // ================= HELP =================

        else if (lower.contains("help")) {

            response =
                    "I can help you with 😊\n\n"
                            + "• Coding & Programming 💻\n"
                            + "• Studies & Exams 📚\n"
                            + "• Motivation 🚀\n"
                            + "• Technology 🤖\n"
                            + "• Health Tips ❤️\n"
                            + "• Fun & Jokes 😂\n"
                            + "• General Conversations";

        }

        // ================= BYE =================

        else if (lower.contains("bye")) {

            response =
                    "Goodbye 👋\n\n"
                            + "Have a wonderful day and take care.";

        }

        // ================= DEFAULT =================

        else {

            response =
                    "That's interesting 😊\n\n"
                            + "I'm still learning and improving.\n"
                            + "Can you tell me more or ask in another way?";
        }

        ChatMessage chat = new ChatMessage();

        chat.setUserId(1L);

        chat.setMessage(message);

        chat.setResponse(response);

        chat.setTimestamp(LocalDateTime.now());

        return chatRepository.save(chat);
    }
}