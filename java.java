document.addEventListener("DOMContentLoaded", () => {
  const chatToggle = document.getElementById("chat-toggle");
  const chatbox = document.getElementById("chatbox");
  const sendBtn = document.getElementById("send-btn");
  const chatInput = document.getElementById("chat-input");
  const chatLog = document.getElementById("chat-log");

  const jokes = [
    "Why don’t programmers like nature? Too many bugs. 🐛",
    "Why do Java developers wear glasses? Because they don’t see sharp. 🤓",
    "Why did the computer go to therapy? It had too many tabs open. 💻",
    "I would tell you a UDP joke… but you might not get it. 📡",
    "Why was the JavaScript developer sad? Because they didn’t ‘null’ their feelings. 😢"
  ];

  chatToggle.addEventListener("click", () => {
    chatbox.classList.toggle("hidden");
  });

  sendBtn.addEventListener("click", () => {
    const userInput = chatInput.value.toLowerCase();
    addMessage("You: " + chatInput.value);

    if (userInput.includes("joke")) {
      const joke = jokes[Math.floor(Math.random() * jokes.length)];
      addMessage("Bot: " + joke);
    } else if (userInput.includes("hello") || userInput.includes("hi")) {
      addMessage("Bot: Hey there! Want to hear a joke? Type 'joke'.");
    } else if (userInput.includes("bye")) {
      addMessage("Bot: Bye! Don’t forget to laugh today 😁");
    } else {
      addMessage("Bot: I only know jokes right now! Try typing 'joke'.");
    }

    chatInput.value = "";
  });

  function addMessage(msg) {
    const p = document.createElement("p");
    p.textContent = msg;
    chatLog.appendChild(p);
    chatLog.scrollTop = chatLog.scrollHeight;
  }
});
