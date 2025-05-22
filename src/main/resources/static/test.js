document.addEventListener("load", () => {
  fetch("https://comic.naver.com/api/webtoon/tagList/shortcut", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Accept: "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then((data) => {
      console.log(data);
      const memberList = document.getElementById("member-list");
      console.log(memberList);
      data.forEach((member) => {
        const li = document.createElement("li");
        li.textContent = member.name;
        memberList.appendChild(li);
      });
    });
});
