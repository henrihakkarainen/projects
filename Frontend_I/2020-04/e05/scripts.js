console.log('REST API is my friend.')
const dataDiv = document.getElementById('data')
console.log('dataDiv:', dataDiv)
// Write your code below...

const xhr = new XMLHttpRequest()
const fakeapi = 'https://jsonplaceholder.typicode.com/posts/1/comments'

xhr.onload = () => {
  if (xhr.status === 200) {
    const data = JSON.parse(xhr.response)
    // filter the data so that only posts with id 1 are included
    const filtered = data.filter(post => post.postId === 1)
    const ulElem = document.createElement('ul')
    for (const post of filtered) {
      const postElem = document.createElement('li')
      postElem.textContent = `post ${post.id}`
      const innerUlElem = document.createElement('ul')
      const commentElem = document.createElement('li')
      // this is the comment of the post?
      commentElem.textContent = post.name
      innerUlElem.appendChild(commentElem)
      postElem.appendChild(innerUlElem)
      ulElem.appendChild(postElem)
    }
    dataDiv.appendChild(ulElem)
  } else {
    console.error('Error!')
  }
}

xhr.open('GET', fakeapi)
xhr.send()
