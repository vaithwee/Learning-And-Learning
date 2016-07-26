/**
 * Created by Vaith on 16/7/26.
 */

var fortunes = [
    "Conquer your fears or they will conquer you.", "Rivers need springs.",
    "Do not fear what you don't know.",
    "You will have a pleasant surprise.", "Whenever possible, keep it simple.",
];

function getFortune() {
    var idx = Math.floor(Math.random() * fortunes.length);
    return fortunes[idx];
}

exports.getFortune = getFortune;