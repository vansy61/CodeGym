// Cho một mảng [1,7,5,9,2,11,6,15]


const arr = [30, 1,7,5,9,2,11,6,15];
// ===============
console.log("In ra các phần tử trong mảng")
for (let i = 0; i < arr.length; i++) {
  console.log(arr[i])
}
// ========================
console.log("In ra các phần tử chẵn trong mảng")
for (let i = 0; i < arr.length; i++) {
  if(arr[i] % 2 == 0) {
    console.log(arr[i])
  }
}
// =============================
console.log("In ra các phần tử tại vị trí chẵn trong mảng")
for (let i = 0; i < arr.length; i++) {
  if(i % 2 == 0) {
    console.log(arr[i])
  }
}
// ===========================
console.log("In ra tổng các phần tử chẵn trong mảng")
let sum = 0;
for (let i = 0; i < arr.length; i++) {
  if(arr[i] % 2 == 0) {
    sum += arr[i]
  }
}
console.log(`Sum is: ${sum}`)
// =============================
console.log("In ra tổng các phần tử > 10 trong mảng")
for (let i = 0; i < arr.length; i++) {
  if(i > 10) {
    console.log(arr[i])
  }
}
// =============================
console.log("In ra tổng các phần tử chia 7 dư 2 trong mảng")
sum = 0;
for (let i = 0; i < arr.length; i++) {
  if(arr[i] % 7 == 2) {
    sum += arr[i];
  }
}
console.log(sum)
// =============================
console.log("In ra max của các phần tử chẵn mảng")
let max = 0;
for (let i = 0; i < arr.length; i++) {
  if(arr[i] % 2 == 0 && max < arr[i]) {
    max = arr[i];
  }
}
console.log(max);
// =============================
console.log("In ra lớn nhất của mảng")
max = arr[0];
for (let i = 1; i < arr.length; i++) {
  if(max < arr[i]) {
    max = arr[i];
  }
}
console.log(max);
// =============================
console.log("In ra số lượng các phần tử chia hết cho 5 trong mảng")
let count = 0;
for (let i = 0; i < arr.length; i++) {
  if(arr[i] % 5 == 0) {
    count++;
  }
}
console.log(count);

// =============================
console.log("In ra trung bình các phần tử chia hết cho 5 trong mảng")
count = 0;
sum = 0;
for (let i = 0; i < arr.length; i++) {
  if(arr[i] % 5 == 0) {
    count++;
    sum += arr[i];
  }
}
console.log(sum/count);

// =============================
console.log("Tìm phần tử lớn thứ 2 trong mảng (nâng cao: 1 vòng lặp)")

let first, second;
for (let i = 0; i < arr.length; i++) {
  if(arr[i] > first || first == undefined) {
    second = first;
    first = arr[i];

  }else if(arr[i] > second || second == undefined) {
    second = arr[i];
  }
}
console.log(second);