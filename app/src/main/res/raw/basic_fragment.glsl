// basic fragment shader - passthrough / simple color tweak
precision mediump float;
varying vec2 vTexCoord;
uniform sampler2D uTexture;
uniform float uSaturation; // example uniform

void main() {
    vec4 color = texture2D(uTexture, vTexCoord);
    // simple desaturation mix to illustrate parameter
    float gray = dot(color.rgb, vec3(0.299, 0.587, 0.114));
    color.rgb = mix(vec3(gray), color.rgb, uSaturation);
    gl_FragColor = color;
}